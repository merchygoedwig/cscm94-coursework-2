package com.group8.mancala.util;

import com.group8.mancala.playerfacing.Player;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class TournamentHelperController {
    @FXML
    private ImageView p1_avi;
    @FXML
    private ImageView p2_avi;
    @FXML
    private Text player1_username;
    @FXML
    private Text player1_fname;
    @FXML
    private Text player1_lname;
    @FXML
    private Text player1_wpercentage;
    @FXML
    private Text player2_username;
    @FXML
    private Text player2_fname;
    @FXML
    private Text player2_lname;
    @FXML
    private Text player2_wpercentage;

    public void initData(Player p1, Player p2) {
        
    }
}
