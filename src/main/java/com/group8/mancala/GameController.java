package com.group8.mancala;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class GameController {
    private final String player_one_username;
    private final String player_two_username;

    @FXML
    private Text PLAYER_ONE_UN;

    @FXML
    private Text PLAYER_TWO_UN;

    public GameController(String pou, String ptu) {
        player_one_username = pou;
        player_two_username = ptu;
    }

    // called by the FXML loader after the labels declared above are injected:
    public void initialize() {

        // do initialization and configuration work...

        // trivial example, could also be done directly in the fxml:
        PLAYER_ONE_UN.setText(player_one_username);
        PLAYER_TWO_UN.setText(player_two_username);
    }
}