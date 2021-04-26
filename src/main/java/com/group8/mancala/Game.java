package com.group8.mancala;
import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Hand;
import com.group8.mancala.playerfacing.Player;
import com.group8.mancala.util.HoleContainer;
import com.group8.mancala.util.HoleLinkedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;

/**
 * Game is the representation of the game of Mancala. It is a singleton class, there can only be one instance of game
 * running at any time, this is to be recorded elsewhere...
 *
 * @author Genevieve Clifford
 * @version 1.1
 */
public class Game {
    private int turnCount = 1;
    private Player player1;
    private Player player2;
    public Player winner;
    public Player loser;

    private GameType gt;

    private TurnKnower tk;

    private GameController gc;

    private boolean compControl;

    public enum GameType {
        TRADITIONAL,
        ARCADE
    }

    /**
     * Creates instance of Game, used when you want to start a game from Main, Administrator...
     */
    public Game(Player player1, Player player2, GameType gt, boolean compControl) {
        this.player1 = player1;
        this.player2 = player2;

        this.gt = gt;

        this.tk = new TurnKnower(this.player1, this.player2);
        player1.setHand(new Hand(player1));
        player2.setHand(new Hand(player2));

        this.compControl = compControl;
    }

    /**
     * Class for tracking turns in a the game of Mancala, there can only ever be two players in a game, hence the two
     * fields for players
     */
    public class TurnKnower {
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
            turnHaver.getHand().setHalfHand(false);
            turnHaver.getHand().setReverseTurn(false);
            turnHaver.getHand().setReverseTurn(false);

            if (turnHaver == p1) {
                turnHaver = p2;
            } else {
                turnHaver = p1;
            }

            if (gt == GameType.ARCADE) {
                Hand hand = tk.turnHaver.getHand();
                gc.continue_turn.setVisible(!hand.usedContinueTurn());
                gc.double_points.setVisible(!hand.usedDoublePoints());
            }

            gc.hideAssetsFromOtherPlayer(this);

            turnCount++;
            gc.turn_count.setText(String.valueOf(turnCount));

            if (turnHaver.isComputerControlled()) {
                turnHaver.getAi().performRandomLegalMove();
            }

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

    public GameController getGc() {
        return gc;
    }

    public GameType getGt() {
        return gt;
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
     * Increments the turn counter for the current instance of Game
     */
    public void incrementTurnCount() {
        turnCount++;
    }

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

    public void determineWinLoss() {
        HoleLinkedList hll = gc.hll;
        Player forfeitedGamePlayer = tk.getTurnHaver();
        Player otherPlayer = tk.getOtherPlayer();

        boolean hasCounters = false;

        HoleContainer ptr = hll.getHead();
        Hole hole = ptr.getHole();
        Player temp;

        while (hole != null) {
            temp = hole.getAssignedPlayer();

            if (hole.getCounterCount() > 0 && hole.getAssignedPlayer() == forfeitedGamePlayer &&
                    hole.gethType() != Hole.HoleType.MANCALA) {
                hasCounters = true;
            }

            if (!(hole.getAssignedPlayer() == forfeitedGamePlayer && hole.gethType() == Hole.HoleType.HOLE)) {
                temp.setCounterTotal(temp.getCounterTotal() + hole.getCounterCount());
            }

            try {
                hole = hole.getSituatedContainer().getNextContainer().getHole();
            } catch (NullPointerException e) {
                break;
            }
        }

        // This is the case where a player forfeits the game before it has concluded
        if (hasCounters) {
            winner = otherPlayer;
            loser = forfeitedGamePlayer;
        } else {
            if (forfeitedGamePlayer.getCounterTotal() > otherPlayer.getCounterTotal()) {
                winner = forfeitedGamePlayer;
                loser = otherPlayer;
            } else {
                loser = forfeitedGamePlayer;
                winner = otherPlayer;
            }
        }
    }

}
