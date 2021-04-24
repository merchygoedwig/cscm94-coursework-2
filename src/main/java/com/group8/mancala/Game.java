package com.group8.mancala;
import com.group8.mancala.playerfacing.Hand;
import com.group8.mancala.playerfacing.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.ArrayList;

/**
 * Game is the representation of the game of Mancala. It is a singleton class, there can only be one instance of game
 * running at any time, this is to be recorded elsewhere...
 *
 * @author Genevieve Clifford
 * @version 1.1
 */
public class Game {
    private int turnCount;
    private Player player1;
    private Player player2;
    private Player winner;
    private Player loser;

    private GameType gt;

    private TurnKnower tk;
    private GameController gc;

    enum GameType {
        TRADITIONAL,
        ARCADE
    }

    /**
     * Creates instance of Game, used when you want to start a game from Main, Administrator...
     */
    public Game(Player player1, Player player2, GameType gt) {
        this.player1 = player1;
        this.player2 = player2;

        this.gt = gt;

        this.tk = new TurnKnower(this.player1, this.player2);
        player1.setHand(new Hand(player1));
        player2.setHand(new Hand(player2));
    }

    /**
     * Class for tracking turns in a the game of Mancala, there can only ever be two players in a game, hence the two
     * fields for players
     */
    class TurnKnower {
        private Player p1;
        private Player p2;
        private Player turnHaver; // I am incredibly sorry about the naming used in this class in general

        /**
         * Main constructor for TurnKnower, give it both instances of Player in the game
         * @param p1 the first player
         * @param p2 the second player
         */
        public TurnKnower(Player p1, Player p2) {
            this.p1 = p1;
            this.p2 = p2;

            this.turnHaver = p1;
        }

        /**
         * Gets the Player for whom the turn is the current one
         * @return Player which currently has the turn
         */
        public Player getTurnHaver() {
            return turnHaver;
        }

        /**
         * Advances the turn over to the next player, also returns the current Player who is having their turn
         * @return Player which currently has the turn
         */
        public Player nextTurn() {
            if (turnHaver == p1) {
                turnHaver = p2;
            } else {
                turnHaver = p1;
            }

            gc.hideAssetsFromOtherPlayer(this);

            return getTurnHaver();
        }

        public Player getOtherPlayer() {
            if (turnHaver == p1) {
                return p2;
            } else {
                return p1;
            }
        }
    }

    public TurnKnower getTk() {
        return tk;
    }

    /**
     * Returns which players are "loaded" into the instance of Game
     * @return ArrayList of Players in the game
     */
    public ArrayList<Player> getPlayersInGame() {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);

        return playerList;
    }

    /**
     * Increments the turn counter for the current instance of com.group8.mancala.java.Game
     */
    public void incrementTurnCount() {
        turnCount++;
    }

//    public void end() throws TransformerException, ParseException {
//        // here will be code for closing GUI windows etc.
//        for (Player player : playersInGame) {
//            currentSession.dao.save(player);
//        }
//    }

    /**
     * Method to start a new instance of GameController using the current game, this (in effect) launches the GUI
     * part of the game.
     * @return optional return, gives the current stage that GameController is running in
     * @throws IOException thrown when the fxml file for the game is not found
     */
    public Stage startGame() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/view/game.fxml"
                )
        );

        Stage stage = Main.getMainStage();
        stage.setScene(
                new Scene(loader.load())
        );

        gc = loader.getController();
        gc.initData(player1, player2);
        stage.show();

        return stage;
    }

    public void hide() {
        gc.hideAssetsFromOtherPlayer(tk);
    }

//    public void updatePlayerScores() {
//        Double winnerScore = winner.getWinPercentage();
//        Double loserScore = loser.getWinPercentage();
//
//        Double expectedProbability = 1.0 / (1.0 + Math.pow(10.0, ((loserScore - winnerScore) / 400.0)));
//
//        Double newWinnerScore = winnerScore +
//    }

}
