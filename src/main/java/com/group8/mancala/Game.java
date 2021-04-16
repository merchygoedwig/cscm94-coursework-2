package com.group8.mancala;
import com.group8.mancala.playerfacing.Player;

import javax.xml.transform.TransformerException;
import java.text.ParseException;

import java.util.ArrayList;

/**
 * com.group8.mancala.java.Game is the representation of the game of com.group8.mancala.java.Mancala, it collaborates with com.group8.mancala.java.Session. It is a singleton class, there
 * can only be one type of com.group8.mancala.java.Game at any one time.
 *
 * @author Genevieve Clifford
 * @version 1.1
 */
public class Game {
    private ArrayList<Player> playersInGame;
    final private Session currentSession;
    private int turnCount;

    /**
     * Creates instance of com.group8.mancala.java.Game, add players with setPlayersInGame()...
     */
    public Game(ArrayList<Player> assignedPlayers, Session thisSession) {
        currentSession = thisSession;
        playersInGame = assignedPlayers;
    }

    public ArrayList<Player> start() {
        // actual game logic goes here
        return playersInGame;
    }

    /**
     * Returns which players are "loaded" into the instance of com.group8.mancala.java.Game
     * @return ArrayList of Players in the game
     */
    public ArrayList<Player> getPlayersInGame() {
        return playersInGame;
    }

    public void setPlayersInGame(ArrayList<Player> players) {
        playersInGame = players;
    }

    /**
     * Increments the turn counter for the current instance of com.group8.mancala.java.Game
     */
    public void incrementTurnCount() {
        turnCount++;
    }

    public void end() throws TransformerException, ParseException {
        // here will be code for closing GUI windows etc.
        for (Player player : playersInGame) {
            currentSession.dao.save(player);
        }
    }
}
