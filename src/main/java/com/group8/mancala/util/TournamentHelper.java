package com.group8.mancala.util;

import com.group8.mancala.Game;
import com.group8.mancala.Main;
import com.group8.mancala.playerfacing.Player;

import java.io.IOException;
import java.util.Stack;

public class TournamentHelper {
    private Stack<Player> playerStack;
    private Player currentPlayer1;
    private Player currentPlayer2;

    public TournamentHelper(Stack<Player> playerStack) {
        this.playerStack = playerStack;
    }

    public void performSetOfTraditionalMatches() throws IOException {
        int numberOfMatches = playerStack.size();
        for (int i = 0; i < numberOfMatches; i++) {
            currentPlayer1 = playerStack.pop();
            currentPlayer2 = playerStack.pop();

            Main.setCurrentGame(new Game(currentPlayer1, currentPlayer2, Game.GameType.TRADITIONAL, false));
            Main.getCurrentGame().startGame();

            playerStack.push(Main.getCurrentGame().getWinner());
        }
    }

    public void doTraditionalTournament() throws IOException {
        while (playerStack.size() > 1) {
            performSetOfTraditionalMatches();
        }
    }
}
