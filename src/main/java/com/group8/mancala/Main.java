package com.group8.mancala;

import com.group8.mancala.Game;
import com.group8.mancala.util.SceneLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage;
    private static Game currentGame;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;

        new SceneLoader("/view/admin.fxml").load();

        mainStage.show();
        mainStage.setTitle("Mancala Game");
    }

    public static Stage getMainStage() {return mainStage;}

    public static Game getCurrentGame() {return currentGame;}

    public static void setCurrentGame(Game game) {
        currentGame = game;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
