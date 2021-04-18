package com.group8.mancala;

import com.group8.mancala.playerfacing.Player;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class GameController {
    private final String player_one_username;
    private final String player_two_username;
    private final String player_one_name;
    private final String player_two_name;
    private final Image p1i;
    private final Image p2i;


    @FXML
    private Text PLAYER_ONE_UN;

    @FXML
    private Text PLAYER_TWO_UN;

    @FXML
    private Text PLAYER_ONE_NA;

    @FXML
    private Text PLAYER_TWO_NA;

    @FXML
    private ImageView PLAYER_ONE_AVI;

    @FXML
    private ImageView PLAYER_TWO_AVI;

    @FXML
    private Text p2h6_text;
    @FXML
    private Text p2h5_text;
    @FXML
    private Text p2h4_text;
    @FXML
    private Text p2h3_text;
    @FXML
    private Text p2h2_text;
    @FXML
    private Text p2h1_text;

    private Text[] p2holes;

    public GameController(Player p1, Player p2) throws FileNotFoundException {
        player_one_username = p1.getUsername();
        player_one_name = p1.getFirstName() + " " + p1.getLastName();
        player_two_name = p2.getFirstName() + " " + p2.getLastName();
        player_two_username = p2.getUsername();
        p1i = new Image(new FileInputStream(p1.getImagePath()));
        p2i = new Image(new FileInputStream(p2.getImagePath()));
        p2holes = new Text[]{p2h6_text, p2h5_text, p2h4_text, p2h3_text, p2h2_text, p2h1_text};
    }

    // called by the FXML loader after the labels declared above are injected:
    public void initialize() {
        PLAYER_ONE_UN.setText(player_one_username);
        PLAYER_TWO_UN.setText(player_two_username);
        PLAYER_ONE_NA.setText(player_one_name);
        PLAYER_TWO_NA.setText(player_two_name);
        PLAYER_ONE_AVI.setImage(p1i);
        PLAYER_TWO_AVI.setImage(p2i);
    }
}