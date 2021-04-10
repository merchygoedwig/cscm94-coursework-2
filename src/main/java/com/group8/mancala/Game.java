package com.group8.mancala;

import com.group8.mancala.playerfacing.Player;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * com.group8.mancala.java.Game is the representation of the game of com.group8.mancala.java.Mancala, it collaborates with com.group8.mancala.java.Session. It is a singleton class, there
 * can only be one type of com.group8.mancala.java.Game at any one time.
 *
 * @author Genevieve Clifford
 * @version 1.1
 */
public class Game {
    final private ArrayList<Player> playersInGame;
    final private Session currentSession;
    private int turnCount;
    final private GameBoard mancalaBoard;

    /**
     * Creates instance of com.group8.mancala.java.Game, add players with setPlayersInGame()...
     */
    public Game(ArrayList<Player> assignedPlayers, Session thisSession, GameBoard thisGameBoard) {
        currentSession = thisSession;
        playersInGame = assignedPlayers;
        mancalaBoard = thisGameBoard;
    }

    /**
     * Returns which players are "loaded" into the instance of com.group8.mancala.java.Game
     * @return ArrayList of Players in the game
     */
    public ArrayList<Player> getPlayersInGame() {
        return playersInGame;
    }

    /**
     * Increments the turn counter for the current instance of com.group8.mancala.java.Game
     */
    public void incrementTurnCount() {
        turnCount++;
    }
}
