package com.group8.mancala;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // just load fxml file and display it in the stage:
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/view/testmain.fxml"));
        SplitPane spane = loader.<SplitPane>load();
        Scene scene = new Scene(spane);
        primaryStage.setTitle("Player Chooser");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class,
        // and calls start(...) on the FX Application thread:
        launch(args);
    }


}