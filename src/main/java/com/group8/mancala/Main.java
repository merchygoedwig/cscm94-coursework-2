package com.group8.mancala;

import com.group8.mancala.persistence.PlayerDao;
import com.group8.mancala.util.SceneLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage;
    private static Game currentGame;
    private static PlayerDao playerDao;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;

        new SceneLoader("/view/admin.fxml").load();

        mainStage.show();
        mainStage.setTitle("Mancala Game");
    }

    /**
     * Getter for the main stage (singleton)
     * @return main stage
     */
    public static Stage getMainStage() {return mainStage;}

    /**
     * Getter for the currently running game (singleton)
     * @return
     */
    public static Game getCurrentGame() {return currentGame;}

    /**
     * Setter for the currently running game (singleton)
     * @param game currently running game
     */
    public static void setCurrentGame(Game game) {
        currentGame = game;
    }

    /**
     * Setter for the global singleton instance of PlayerDao
     * @param dao global DAO
     */
    public static void setPlayerDao(PlayerDao dao) {
        playerDao = dao;
    }

    /**
     * Getter for the global singleton instance of PlayerDao
     * @return global DAO
     */
    public static PlayerDao getPlayerDao() {
        return playerDao;
    }

    /**
     * Entry point for the JavaFX application
     * @param args do not set any args, they won't do anything
     */
    public static void main(String[] args) {
        launch(args);
    }
}
