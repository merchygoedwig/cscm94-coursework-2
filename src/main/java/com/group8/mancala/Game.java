package com.group8.mancala;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * com.group8.mancala.java.Game is the representation of the game of com.group8.mancala.java.Mancala, it collaborates with com.group8.mancala.java.Session. It is a singleton class, there
 * can only be one type of com.group8.mancala.java.Game at any one time.
 *
 * @author Genevieve Clifford
 * @version 1.0
 */
public class Game {
    private ArrayList<Player> playersInGame;
    private Session currentSession;
    private int turnCount;
    private LinkedList<Hole> gameHoles;

    /**
     * Creates instance of com.group8.mancala.java.Game, add players with setPlayersInGame()...
     */
    public Game() {}

    /**
     * Returns which players are "loaded" into the instance of com.group8.mancala.java.Game
     * @return ArrayList of Players in the game
     */
    public ArrayList<Player> getPlayersInGame() {
        return playersInGame;
    }

    /**
     * Sets which players are to be "loaded" into the instance of com.group8.mancala.java.Game
     * @param player1 The first player in com.group8.mancala.java.Game
     * @param player2 The second player in com.group8.mancala.java.Game
     */
    public void setPlayersInGame(Player player1, Player player2) {
        playersInGame.add(player1);
        playersInGame.add(player2);
    }

    /**
     * Increments the turn counter for the current instance of com.group8.mancala.java.Game
     */
    public void incrementTurnCount() {
        turnCount++;
    }
}
