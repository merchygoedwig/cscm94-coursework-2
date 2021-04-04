package com.group8.mancala.java;

import com.group8.mancala.playerfacing.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import com.group8.mancala.gameplayobjects.Hole;

/**
 * com.group8.mancala.Game is the representation of the game of com.group8.mancala.gameplayobjects.Mancala, it collaborates with com.group8.mancala.Session. It is a singleton class, there
 * can only be one type of com.group8.mancala.Game at any one time.
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
     * Creates an instance of com.group8.mancala.Game with the default ruleset
     */
    public Game() {
    }

    /**
     * Returns which players are "loaded" into the instance of com.group8.mancala.Game
     *
     * @return ArrayList of Players in the game
     */
    public ArrayList<Player> getPlayersInGame() {
        return playersInGame;
    }

    /**
     * Sets which players are to be "loaded" into the instance of com.group8.mancala.Game
     *
     * @param player1 The first player in com.group8.mancala.Game
     * @param player2 The second player in com.group8.mancala.Game
     */
    public void setPlayersInGame(Player player1, Player player2) {
        playersInGame.add(player1);
        playersInGame.add(player2);
    }

    /**
     * Increments the turn counter for the current instance of com.group8.mancala.Game
     */
    public void incrementTurnCount() {
        turnCount++;
    }

}
