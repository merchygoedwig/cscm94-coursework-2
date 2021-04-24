package com.group8.mancala;

import com.group8.mancala.util.SceneLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage mainStage;
    private static Game currentGame;

    /**
     * The standard JavaFX start method for launching the main application, which in this instance is a stub. The
     * controller found in MainController is currently a stub which will be replaced by Isaac's AdministratorController
     * class on Sunday (I hope). VERY IMPORTANT: when spawning new scenes, it is important that you do so using code
     * like that given here in the start method. The controller is defined IN THE FXML FILE. I really can't make this
     * any more clear other than if I lit the text on fire or whatever. You get the controller from the JavaFX FXML
     * file, not by defining it yourself in your own file (i.e. look at Game, use the loader.setController() method)!
     * If you do it by defining it yourself, you'll end up basically telling the game that you have two controllers
     * for the view at the same time, which is a BAD thing. Trust me, I spent TWO WHOLE DAYS trying to fix this
     * problem on my own, Java just disregards all of your annotated (@FXML) declarations and then smugly throws a
     * NullPointerException in your face, which is less than ideal!
     * @param stage optional return of the main (singleton) stage instance
     * @throws Exception when you've been naughty and Santa Claus gives you no presents because you have declared an
     * invalid or otherwise missing FXML file
     */
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;

        new SceneLoader("/view/testmain.fxml").load();

        mainStage.show();
        mainStage.setTitle("Untitled Mancala Game");
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game game) {
        currentGame = game;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
