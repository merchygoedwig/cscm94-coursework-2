package com.group8.mancala;
import com.group8.mancala.playerfacing.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.transform.TransformerException;
import java.io.IOException;
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
    private int turnCount;
    private Player player1;
    private Player player2;
    private TurnKnower tk;

    /**
     * Creates instance of com.group8.mancala.java.Game, add players with setPlayersInGame()...
     */
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.tk = new TurnKnower(this.player1, this.player2);
    }

    class TurnKnower {
        private Player p1;
        private Player p2;
        private Player turnHaver;

        public TurnKnower(Player p1, Player p2) {
            this.p1 = p1;
            this.p2 = p2;

            this.turnHaver = p1;
        }

        public Player getTurnHaver() {
            return turnHaver;
        }

        public Player nextTurn() {
            if (turnHaver == p1) {
                turnHaver = p2;
            } else {
                turnHaver = p1;
            }
            return getTurnHaver();
        }
    }

    /**
     * Returns which players are "loaded" into the instance of com.group8.mancala.java.Game
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

        GameController controller = loader.getController();
        controller.initData(player1, player2);
        stage.show();

        return stage;
    }
}
