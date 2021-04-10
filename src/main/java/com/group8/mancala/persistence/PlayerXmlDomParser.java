package com.group8.mancala.persistence;

import com.group8.mancala.playerfacing.Player;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;

public class PlayerXmlDomParser {
    final private NodeList players;

    public PlayerXmlDomParser(String filepath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File playerXML = new File(filepath);
        Document document = builder.parse(playerXML);
        document.getDocumentElement().normalize();
        players = document.getElementsByTagName("player");
    }

    private String getXMLAttribute(Element elementToGet, String tagName) {
        return elementToGet.getElementsByTagName(tagName).item(0).getTextContent();
    }

    public Player getPlayerByUUID(UUID uuid) throws ParseException {

        String uuidString = uuid.toString();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        for (int i = 0; i < players.getLength(); i++) {
            Node player = players.item(i);
            if (player.getNodeType() == Node.ELEMENT_NODE) {
                Element ePlayer = (Element) player;
                if (ePlayer.getAttribute("uuid").equals(uuidString)) {
                    String username = getXMLAttribute(ePlayer, "username");
                    String firstName = getXMLAttribute(ePlayer, "firstname");
                    String lastName = getXMLAttribute(ePlayer, "lastname");
                    Date lastLogin = dateFormatter.parse(
                            getXMLAttribute(ePlayer, "imagepath")
                    );
                    String imagePath = getXMLAttribute(ePlayer, "imagepath");
                    float winPercentage = Float.parseFloat(
                            getXMLAttribute(ePlayer, "winpercentage")
                    );
                    return new Player(uuid, username, firstName, lastName, lastLogin, imagePath, winPercentage);
                }
            }
        }
        return new Player();
    }

    public Player getPlayerByUsername(String un) throws ParseException {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        for (int i = 0; i < players.getLength(); i++) {
            Node player = players.item(i);
            if (player.getNodeType() == Node.ELEMENT_NODE) {
                Element ePlayer = (Element) player;
                if (getXMLAttribute(ePlayer, "username").equals(un)) {
                    UUID uuid = UUID.fromString(
                            ePlayer.getAttribute("uuid")
                    );
                    String username = getXMLAttribute(ePlayer, "username");
                    String firstName = getXMLAttribute(ePlayer, "firstname");
                    String lastName = getXMLAttribute(ePlayer, "lastname");
                    Date lastLogin = dateFormatter.parse(
                            getXMLAttribute(ePlayer, "imagepath")
                    );
                    String imagePath = getXMLAttribute(ePlayer, "imagepath");
                    float winPercentage = Float.parseFloat(
                            getXMLAttribute(ePlayer, "winpercentage")
                    );
                    return new Player(uuid, username, firstName, lastName, lastLogin, imagePath, winPercentage);
                }
            }
        }
        return new Player();
    }
}
