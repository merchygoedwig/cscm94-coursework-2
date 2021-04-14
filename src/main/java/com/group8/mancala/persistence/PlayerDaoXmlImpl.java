package com.group8.mancala.persistence;

import com.group8.mancala.playerfacing.Player;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PlayerDaoXmlImpl implements PlayerDao{
    final private Document document;
    final private NodeList players;
    final private SimpleDateFormat dateFormatter;
    private ArrayList<Player> playerList;

    public PlayerDaoXmlImpl(String filepath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File playerXML = new File(filepath);
        document = builder.parse(playerXML);
        document.getDocumentElement().normalize();
        players = document.getElementsByTagName("player");
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
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
        float winPercentage = Float.parseFloat(
                _getXMLAttribute(ePlayer, "winpercentage")
        );
        return new Player(uuid, username, firstName, lastName, lastLogin, imagePath, winPercentage);
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
        playerList.clear();
        int i;
        for (i = 0; i < players.getLength(); i++) {
            Node player = players.item(i);
            Element ePlayer = (Element) player;
            playerList.add(_createPlayerFromXML(ePlayer));
        }
        return playerList;
    }

    @Override
    public List<Player> getAll() throws ParseException {
        return _getAll();
    }

    @Override
    public void save(Player player) {

    }

    @Override
    public void update(Player player, String[] updates) {

    }

    @Override
    public void delete(Player player) {

    }

//    public void persistPlayerChanges(ArrayList<Player> players) {
//        for (Player player : players) {
//
//        }
//    }
}
