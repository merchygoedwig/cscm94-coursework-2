package com.group8.mancala.util;

import com.group8.mancala.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Utility function to make loading scenes for the main stage much much easier
 * @author Genevieve Clifford
 * @version InDev
 */
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
