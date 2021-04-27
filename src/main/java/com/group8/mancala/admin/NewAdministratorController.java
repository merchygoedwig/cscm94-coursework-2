package com.group8.mancala.admin;

import com.group8.mancala.Game;
import com.group8.mancala.Main;
import com.group8.mancala.persistence.PlayerDao;
import com.group8.mancala.persistence.PlayerDaoXmlImpl;
import com.group8.mancala.playerfacing.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Controller for FXML Main class that deals with player assignment
 * @author Genevieve Clifford
 * @version InDev
 */
public class NewAdministratorController {

    Player player1;
    Player player2;

    PlayerDao dao = new PlayerDaoXmlImpl("src/main/resources/xml/players.xml");

    @FXML
    private TableView<Player> player_table;

    private PlayerPreview p1_pp;
    @FXML
    private ImageView p1_avi;
    @FXML
    private Text p1_username;
    @FXML
    private Text p1_fname;
    @FXML
    private Text p1_lname;
    @FXML
    private Text p1_wpercent;
    @FXML
    private Button assign_p1;

    private PlayerPreview p2_pp;
    @FXML
    private ImageView p2_avi;
    @FXML
    private Text p2_username;
    @FXML
    private Text p2_fname;
    @FXML
    private Text p2_lname;
    @FXML
    private Text p2_wpercent;
    @FXML
    private Button assign_p2;

    @FXML
    private Button traditional_mode;

    @FXML
    private Button arcade_mode;

    private ArrayList<Player> playerListFromDao;

    class PlayerPreview {
        Text username;
        Text fname;
        Text lname;
        Text wper;
        ImageView iview;

        PlayerPreview(Text un, Text fn, Text ln, Text wp, ImageView iv) {
            username = un;
            fname = fn;
            lname = ln;
            wper = wp;
            iview = iv;
        }

        public void update(String un, String fn, String ln, String wp, String ip) throws FileNotFoundException {
            username.setText(un);
            fname.setText(fn);
            lname.setText(ln);
            wper.setText(wp);
            iview.setImage(new Image(new FileInputStream(ip)));
        }

        public void update(Player p) throws FileNotFoundException {
            username.setText(p.getUsername());
            fname.setText(p.getFirstName());
            lname.setText(p.getLastName());
            wper.setText(String.valueOf(p.getWinPercentage()));
            iview.setImage(new Image(new FileInputStream(p.getImagePath())));
        }

        public void setVisible() {
            username.setVisible(true);
            fname.setVisible(true);
            lname.setVisible(true);
            wper.setVisible(true);
            iview.setVisible(true);
        }

        public void setInvisible() {
            username.setVisible(false);
            fname.setVisible(false);
            lname.setVisible(false);
            wper.setVisible(false);
            iview.setVisible(false);
        }
    }

    public NewAdministratorController() throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
    }

    public void initialize() throws ParseException {
        playerListFromDao = dao.getAll();

        TableColumn<Player, String> usernameCol = new TableColumn<>("Username");
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Player, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Player, String> lNameCol = new TableColumn<>("Last Name");
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Player, String> wPercent = new TableColumn<>("W%");
        wPercent.setCellValueFactory(new PropertyValueFactory<>("winPercentage"));

        player_table.getColumns().add(usernameCol);
        player_table.getColumns().add(fNameCol);
        player_table.getColumns().add(lNameCol);
        player_table.getColumns().add(wPercent);

        for (Player p : playerListFromDao) {
            player_table.getItems().add(p);
        }

        p1_pp = new PlayerPreview(p1_username, p1_fname, p1_lname, p1_wpercent, p1_avi);
        p2_pp = new PlayerPreview(p2_username, p2_fname, p2_lname, p2_wpercent, p2_avi);

        p1_pp.setInvisible();
        p2_pp.setInvisible();

        assign_p1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Player selectedPlayer = player_table.getSelectionModel().getSelectedItem();
                    p1_pp.setVisible();
                    p1_pp.update(selectedPlayer);
                    player1 = selectedPlayer;
                } catch (NullPointerException | FileNotFoundException e) {
                    p1_pp.setInvisible();
                }
            }
        });

        assign_p2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Player selectedPlayer = player_table.getSelectionModel().getSelectedItem();
                    p2_pp.setVisible();
                    p2_pp.update(selectedPlayer);
                    player2 = selectedPlayer;
                } catch (NullPointerException | FileNotFoundException e) {
                    p2_pp.setInvisible();
                }
            }
        });

        traditional_mode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.setCurrentGame(new Game(player1, player2, Game.GameType.TRADITIONAL, false));
                try {
                    Main.getCurrentGame().startGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        arcade_mode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.setCurrentGame(new Game(player1, player2, Game.GameType.ARCADE, false));
                try {
                    Main.getCurrentGame().startGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
