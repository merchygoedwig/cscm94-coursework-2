package com.group8.mancala;

import com.group8.mancala.persistence.PlayerDao;
import com.group8.mancala.persistence.PlayerDaoXmlImpl;
import com.group8.mancala.playerfacing.Player;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class Session {
    final private ArrayList<Player> candidatePlayers;
    public PlayerDao dao;

    public Session(ArrayList<Player> assignedPlayers) throws IOException, SAXException, ParserConfigurationException, TransformerConfigurationException {
        candidatePlayers = assignedPlayers;
        dao = new PlayerDaoXmlImpl("players.xml");
    }

    public void beginGame(ArrayList<Player> players) throws TransformerException, ParseException {
        if (players.size() == 2) {
            Game currentGame = new Game(players, this);
            players = currentGame.start(); // this is the entirety of the game
            currentGame.end();
        } else {
            // tournament mode code here
        }
    }
}
