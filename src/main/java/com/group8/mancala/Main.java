package com.group8.mancala;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // just load fxml file and display it in the stage:

//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(new URL("file:///home/gcli/Git/cscm94-coursework-2/src/main/java/com/group8/mancala/game.fxml"));
//        loader.setControllerFactory(c -> {
//            return new GameController("merchygoedwig", "jjat321");
//        });
//        AnchorPane anchorPane = loader.<AnchorPane>load();
//        Scene scene = new Scene(anchorPane);
//        primaryStage.setScene(scene);
//        primaryStage.show();

        primaryStage.setTitle("Mancala Launcher (Test Class)");

        Button launcher = new Button("Launch Test Game");

        launcher.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                try {
                    startGame(primaryStage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Scene scene = new Scene(launcher);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startGame(Stage loadedStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///home/gcli/Git/cscm94-coursework-2/src/main/java/com/group8/mancala/game.fxml"));
        loader.setControllerFactory(c -> {
            return new GameController("merchygoedwig", "jjat321");
        });
        AnchorPane anchorPane = loader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        loadedStage.setScene(scene);
        loadedStage.show();
    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class,
        // and calls start(...) on the FX Application thread:
        launch(args);
    }
}