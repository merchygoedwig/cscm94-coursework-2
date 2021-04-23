package com.group8.mancala.util;

import com.group8.mancala.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneLoader {
    private final String filepath;

    public SceneLoader(String filepath) {
        this.filepath = filepath;
    }

    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(filepath));
        try {
            Main.getMainStage().setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
