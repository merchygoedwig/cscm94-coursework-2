package com.group8.mancala;

import com.group8.mancala.playerfacing.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameController {
    private final String player_one_username;
    private final String player_two_username;
    private final Image p1i;
    private final Image p2i;


    @FXML
    private Text PLAYER_ONE_UN;

    @FXML
    private Text PLAYER_TWO_UN;

    @FXML
    private ImageView PLAYER_ONE_AVI;

    @FXML
    private ImageView PLAYER_TWO_AVI;

    public GameController(Player p1, Player p2) throws FileNotFoundException {
        player_one_username = p1.getUsername();
        player_two_username = p2.getUsername();
        p1i = new Image(new FileInputStream(p1.getImagePath()));
        p2i = new Image(new FileInputStream(p2.getImagePath()));
    }

    // called by the FXML loader after the labels declared above are injected:
    public void initialize() {

        // do initialization and configuration work...

        // trivial example, could also be done directly in the fxml:
        PLAYER_ONE_UN.setText(player_one_username);
        PLAYER_TWO_UN.setText(player_two_username);
        PLAYER_ONE_AVI.setImage(p1i);
        PLAYER_TWO_AVI.setImage(p2i);
    }
}