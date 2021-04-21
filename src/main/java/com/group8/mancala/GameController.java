package com.group8.mancala;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameController {
    public Player player1;
    public Player player2;

    public Hole[] p1h;
    public Hole[] p2h;

    @FXML
    public Text PLAYER_ONE_UN;

    @FXML
    public Text PLAYER_TWO_UN;

    @FXML
    public Text PLAYER_ONE_NA;

    @FXML
    public Text PLAYER_TWO_NA;

    @FXML
    public ImageView PLAYER_ONE_AVI;

    @FXML
    public ImageView PLAYER_TWO_AVI;

    @FXML
    public Text p1h6_text;
    @FXML
    public Text p1h5_text;
    @FXML
    public Text p1h4_text;
    @FXML
    public Text p1h3_text;
    @FXML
    public Text p1h2_text;
    @FXML
    public Text p1h1_text;

    @FXML
    public Text p2h6_text;
    @FXML
    public Text p2h5_text;
    @FXML
    public Text p2h4_text;
    @FXML
    public Text p2h3_text;
    @FXML
    public Text p2h2_text;
    @FXML
    public Text p2h1_text;

    public GameController() {}

    public void initData(Player p1, Player p2) throws FileNotFoundException {
        player1 = p1;
        player2 = p2;

        PLAYER_ONE_UN.setText(player1.getUsername());
        PLAYER_TWO_UN.setText(player2.getUsername());
        PLAYER_ONE_NA.setText(player1.getFirstName() + " " + player1.getLastName());
        PLAYER_TWO_NA.setText(player2.getFirstName() + " " + player2.getLastName());
        Image p1i = new Image(new FileInputStream(player1.getImagePath()));
        Image p2i = new Image(new FileInputStream(player2.getImagePath()));
        PLAYER_ONE_AVI.setImage(p1i);
        PLAYER_TWO_AVI.setImage(p2i);

        Text [] p1htext = new Text[]{p1h1_text, p1h2_text, p1h3_text, p1h4_text, p1h5_text, p1h6_text};


        p1h = new Hole[p1htext.length];

        for (int i = 0; i < p1htext.length; i++) {
            p1h[i] = new Hole(player1, p1htext[i]);
        }

        for (Hole p1holes : p1h) {
            p1holes.updateLabel();
        }

        Text [] p2htext = new Text[]{p2h1_text, p2h2_text, p2h3_text, p2h4_text, p2h5_text, p2h6_text};
        

        p2h = new Hole[p2htext.length];

        for (int i = 0; i < p2htext.length; i++) {
            p2h[i] = new Hole(player2, p2htext[i]);
        }

        for (Hole p2holes : p2h) {
            p2holes.updateLabel();
        }

    }

    public void beginGame(ActionEvent actionEvent) {
//        p2h1.updateLabel();
    }
}