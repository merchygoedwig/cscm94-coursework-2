package com.group8.mancala;

import com.group8.mancala.playerfacing.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class AdministratorStubController {
    Player player1;
    Player player2;

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
                "oofIJustBitIntoBone",
                "Jerma",
                "985",
                new Date(),
                "src/main/resources/view/jerma_mcchicken.jpeg",
                0.757
        );

        player1 = jermasus;
        player2 = otherjerma;

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

    @FXML
    public void startGame(Stage loadedStage, Player p1, Player p2) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/view/game.fxml"));
        loader.setControllerFactory(c -> {
            try {
                return new GameController(p1, p2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        });
        Pane pane = loader.<AnchorPane>load();
        Scene scene = new Scene(pane);
        loadedStage.setTitle("Mancala Game");
        loadedStage.setScene(scene);
        loadedStage.show();
    }

    public void clickStartGame(ActionEvent actionEvent) throws IOException {
        startGame(new Stage(), player1, player2);
    }
}

