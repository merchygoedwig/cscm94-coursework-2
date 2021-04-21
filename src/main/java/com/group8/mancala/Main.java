package com.group8.mancala;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;

        new SceneLoader("/view/testmain.fxml").load();

        mainStage.show();
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
