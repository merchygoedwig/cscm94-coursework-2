package com.group8.mancala.java;

/**
 * Session tracks the results of each player, it collaborates with game.
 *
 * @author Joshua Thurman
 * @version 1.0
 */

import java.io.File;

public interface Session1 {
    public int winPercentage(int i, int n);

    public Game startGame();

    public Game1 saveGame();

    public Game2 endGame();

    public Players getMostFrequentPlayers();

    public PowerUps getLastPowerUps();

    public Changes persistChanges();

    public File readFile();
}
