package com.group8.mancala.persistence;

import com.group8.mancala.playerfacing.Player;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * An implementation of the PlayerDao interface which makes use of an XML file for the "backend". Here we use a DOM
 * parser for the XML file. Due to the relatively small number of unique players which is expected for version 1.0, a
 * DOM parser makes sense to implement here. If the game were to be played by many tens or hundreds of players, it
 * would be more memory efficient to use a SAX parser for the DAO. Obviously it would be even better to use say, a
 * SQL (SQLite) database for persistence and serialisation, but this complies with the specification.
 * @author Genevieve Clifford
 * @version InDev
 */
public class PlayerDaoXmlImpl implements PlayerDao{
    final private Document document;
    final private NodeList players;
    final private SimpleDateFormat dateFormatter;
    private ArrayList<Player> playerList = new ArrayList<>();
    final private Element root;
    private Transformer transformer;
    private String fp;

    public PlayerDaoXmlImpl(String filepath) throws ParserConfigurationException, IOException, SAXException,
            TransformerConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File playerXML = new File(filepath);
        document = builder.parse(playerXML);
        root = document.getDocumentElement();
        root.normalize();
        players = document.getElementsByTagName("player");
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformer = transformerFactory.newTransformer();
        fp = filepath;
    }

    private String _getXMLAttribute(Element elementToGet, String tagName) {
        return elementToGet.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private Element _getElementByUUID(UUID uuid) throws ParseException{
        int i;
        for (i = 0; i < players.getLength(); i++) {
            Node player = players.item(i);
            Element ePlayer = (Element) player;
            if (player.getNodeType() == Node.ELEMENT_NODE && ePlayer.getAttribute("uuid").equals(uuid.toString())) {
                return ePlayer;
            }
        }
        throw new ParseException(String.format("Couldn't find %s in XML file.", uuid.toString()), i);
    }

    private Element _getElementByUsername(String un) throws ParseException{
        int i;
        for (i = 0; i < players.getLength(); i++) {
            Node player = players.item(i);
            Element ePlayer = (Element) player;
            if (player.getNodeType() == Node.ELEMENT_NODE &&
                    _getXMLAttribute(ePlayer, "username").equals(un)) {
                return ePlayer;
            }
        }
        throw new ParseException(String.format("Couldn't find %s in XML file.", un), i);
    }

    private Player _createPlayerFromXML(Element ePlayer) throws ParseException {
        UUID uuid = UUID.fromString(
                ePlayer.getAttribute("uuid")
        );
        String username = _getXMLAttribute(ePlayer, "username");
        String firstName = _getXMLAttribute(ePlayer, "firstname");
        String lastName = _getXMLAttribute(ePlayer, "lastname");
        Date lastLogin = dateFormatter.parse(
                _getXMLAttribute(ePlayer, "lastlogin")
        );
        String imagePath = _getXMLAttribute(ePlayer, "imagepath");
        int winCount = Integer.parseInt(
                _getXMLAttribute(ePlayer, "winpercentage")
        );
        return new Player(uuid, username, firstName, lastName, lastLogin, imagePath, winCount);
    }

    @Override
    public Player get(UUID uuid) throws ParseException {
        Element ePlayer = _getElementByUUID(uuid);
        return _createPlayerFromXML(ePlayer);
    }

    @Override
    public Player get(String un) throws ParseException {
        Element ePlayer = _getElementByUsername(un);
        return _createPlayerFromXML(ePlayer);
    }


    private ArrayList<Player> _getAll() throws ParseException {
        int i;
        for (i = 0; i < players.getLength(); i++) {
            Node player = players.item(i);
            Element ePlayer = (Element) player;
            playerList.add(_createPlayerFromXML(ePlayer));
        }
        return playerList;
    }

    @Override
    public ArrayList<Player> getAll() throws ParseException {
        return _getAll();
    }

    @Override
    public void save(Player player) throws TransformerException {
        Element newPlayer = document.createElement("player");
        newPlayer.setAttribute("uuid", player.getUuid().toString());

        Element username = document.createElement("username");
        Element firstName = document.createElement("firstname");
        Element lastName = document.createElement("lastname");
        Element lastLogin = document.createElement("lastlogin");
        Element imagePath = document.createElement("imagepath");
        Element winPercentage = document.createElement("winpercentage");

        username.appendChild(document.createTextNode(player.getUsername()));
        newPlayer.appendChild(username);

        firstName.appendChild(document.createTextNode(player.getFirstName()));
        newPlayer.appendChild(firstName);

        lastName.appendChild(document.createTextNode(player.getLastName()));
        newPlayer.appendChild(lastName);

        lastLogin.appendChild(document.createTextNode(dateFormatter.format(player.getLastLogin())));
        newPlayer.appendChild(lastLogin);

        imagePath.appendChild(document.createTextNode(player.getImagePath()));
        newPlayer.appendChild(imagePath);

        winPercentage.appendChild(document.createTextNode(String.valueOf(player.getWinCount())));
        newPlayer.appendChild(winPercentage);

        root.appendChild(newPlayer);

        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(fp);
        transformer.transform(source, result);
        document.normalize();
    }

    @Override
    public void update(Player player) throws ParseException, TransformerException {
        delete(player);
        save(player);
    }

    @Override
    public void delete(Player player) throws ParseException {
        Element ePlayer = _getElementByUUID(player.getUuid());
        ePlayer.getParentNode().removeChild(ePlayer);
    }
}
