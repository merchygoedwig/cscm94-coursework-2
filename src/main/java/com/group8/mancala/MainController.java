package com.group8.mancala;

import com.group8.mancala.playerfacing.ComputerControl;
import com.group8.mancala.playerfacing.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * This is a controller for the current Main class, absolutely none of this code is final and should be considered a
 * stub or whatever its meant to be called
 */
public class MainController {

    Player player1;
    Player player2;
    Player computer;

    @FXML
    private ImageView P1I;
    @FXML
    private Text P1U;
    @FXML
    private Text P1F;
    @FXML
    private Text P1L;
    @FXML
    private Text P1W;

    @FXML
    private ImageView P2I;
    @FXML
    private Text P2U;
    @FXML
    private Text P2F;
    @FXML
    private Text P2L;
    @FXML
    private Text P2W;

    /**
     * Runs when controller is initialised
     * @throws FileNotFoundException this is thrown when the fxml file is not found
     */
    public void initialize() throws FileNotFoundException {
        Player jermasus = new Player(
                "whenTheImposterIsSus",
                "Jerma",
                "985",
                new Date(),
                "src/main/resources/view/JermaSus.jpg",
                0.922
        );

        Player otherjerma = new Player(
                "merchygoedwig",
                "Genevieve",
                "Clifford",
                new Date(),
                "src/main/resources/view/genevieve_fursona.png",
                0.757
        );

        Player kryten = new Player(
                "commanderUBend",
                "Kryten",
                "2X4B-523P",
                new Date(),
                "src/main/resources/view/kryten.jpeg",
                0.25
        );

        kryten.setComputerControlled(true);

        computer = kryten;
        player1 = otherjerma;
        player2 = jermasus;

        P1I.setImage(new Image(new FileInputStream(jermasus.getImagePath())));
        P1U.setText(jermasus.getUsername());
        P1F.setText(jermasus.getFirstName());
        P1L.setText(jermasus.getLastName());
        P1W.setText(String.valueOf(jermasus.getWinPercentage()));

        P2I.setImage(new Image(new FileInputStream(otherjerma.getImagePath())));
        P2U.setText(otherjerma.getUsername());
        P2F.setText(otherjerma.getFirstName());
        P2L.setText(otherjerma.getLastName());
        P2W.setText(String.valueOf(otherjerma.getWinPercentage()));
    }

    /**
     * Action for the "Start Game" button, in this case, starts an instance of the traditional game
     * @param actionEvent
     * @throws IOException
     */
    public void clickStartGame(ActionEvent actionEvent) throws IOException {
        Main.setCurrentGame(new Game(player1, player2, Game.GameType.TRADITIONAL, false));
        Main.getCurrentGame().startGame();
    }

    public void startComputerGame(ActionEvent actionEvent) throws IOException {
        Main.setCurrentGame(new Game(player1, computer, Game.GameType.TRADITIONAL, true));
        Main.getCurrentGame().startGame();
    }

    public void startArcadeGame(ActionEvent actionEvent) throws IOException {
        Main.setCurrentGame(new Game(player1, player2, Game.GameType.ARCADE, false));
        Main.getCurrentGame().startGame();
    }
}
