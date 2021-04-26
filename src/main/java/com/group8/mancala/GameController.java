package com.group8.mancala;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Player;
import com.group8.mancala.util.HoleContainer;
import com.group8.mancala.util.HoleLinkedList;
import com.group8.mancala.util.SceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * JavaFX controller which interfaces with both the underlying Game class, and also the FXML described view, giving a
 * complete MVC hat-trick. Only used with the singleton instance of Game (Main.Game).
 */
public class GameController {

    public Player player1;
    public Player player2;

    public Hole[] p1h;
    public Hole[] p2h;
//    public Mancala p1m;
//    public Mancala p2m;

    private final Game game;

    public HoleLinkedList hll;

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
    public Text p1m_text;

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

    @FXML
    private Text p2m_text;

    @FXML
    Text turn_count;

    @FXML
    public Text player_one_indicator;

    @FXML
    public Text player_two_indicator;

    @FXML
    private Button end_game;

    Button[] p1button;

    @FXML
    Button blank_button;

    @FXML
    Button p1h1_sel;
    @FXML
    Button p1h2_sel;
    @FXML
    Button p1h3_sel;
    @FXML
    Button p1h4_sel;
    @FXML
    Button p1h5_sel;
    @FXML
    Button p1h6_sel;

    @FXML
    Button p2h1_sel;
    @FXML
    Button p2h2_sel;
    @FXML
    Button p2h3_sel;
    @FXML
    Button p2h4_sel;
    @FXML
    Button p2h5_sel;
    @FXML
    Button p2h6_sel;

    /**
     * Constructor for GameController only sets the singleton class for the local variable `game`
     */
    public GameController() {
        this.game = Main.getCurrentGame();
    }

    /**
     * Sets data up for the GameController instance, this is called from the Main/Administrator etc. class just after
     * the instance of GameController has been initiated.
     * @param p1 player one in the game
     * @param p2 player two in the game
     * @throws FileNotFoundException thrown when image files are not found
     */
    public void initData(Player p1, Player p2) throws FileNotFoundException {
        // Declaring instance variables for player from constructor
        player1 = p1;
        player2 = p2;

        // Putting the player name, username and images on the top of the screen
        PLAYER_ONE_UN.setText(player1.getUsername());
        PLAYER_TWO_UN.setText(player2.getUsername());
        PLAYER_ONE_NA.setText(player1.getFirstName() + " " + player1.getLastName());
        PLAYER_TWO_NA.setText(player2.getFirstName() + " " + player2.getLastName());
        Image p1i = new Image(new FileInputStream(player1.getImagePath()));
        Image p2i = new Image(new FileInputStream(player2.getImagePath()));
        PLAYER_ONE_AVI.setImage(p1i);
        PLAYER_TWO_AVI.setImage(p2i);

        // Creation of holes and their associated text objects (showing counter count)
        hll = new HoleLinkedList();

        Text [] p1htext = new Text[]{p1h1_text, p1h2_text, p1h3_text, p1h4_text, p1h5_text, p1h6_text};
        p1button = new Button[]{p1h1_sel, p1h2_sel, p1h3_sel, p1h4_sel, p1h5_sel, p1h6_sel};

//        p1h = new Hole[p1htext.length];
        for (int i = 0; i < p1htext.length; i++) {
            hll.addHole(new Hole(player1, p1htext[i], p1button[i], Hole.HoleType.HOLE));
        }

        hll.addHole(new Hole(player1, p1m_text, blank_button, Hole.HoleType.MANCALA));

        Text [] p2htext = new Text[]{p2h1_text, p2h2_text, p2h3_text, p2h4_text, p2h5_text, p2h6_text};
        Button[] p2button = new Button[]{p2h1_sel, p2h2_sel, p2h3_sel, p2h4_sel, p2h5_sel, p2h6_sel};



        for (int i = 0; i < p2htext.length; i++) {
            hll.addHole(new Hole(player2, p2htext[i], p2button[i], Hole.HoleType.HOLE));
        }

        hll.addHole(new Hole(player2, p2m_text, blank_button, Hole.HoleType.MANCALA));

        // Setting the initial counter count text for each hole
        HoleContainer ptr = hll.getHead();

        while (ptr != null) {
            ptr.getHole().updateLabelAndButtonVisibility();
            ptr = ptr.getNextContainer();
        }

        // Hides control elements for player two initially
        Main.getCurrentGame().hide();

        turn_count.setText("1");
    }

    /**
     * Hides control elements for the player who their turn is not the current one
     * @param tk singleton class of TurnKnower from the singleton instance of Game
     */
    public void hideAssetsFromOtherPlayer(Game.TurnKnower tk) {
        Player player = tk.getOtherPlayer();

        HoleContainer curPtr = hll.getHead();
        Hole hole;

        while (curPtr != null) {
            hole = curPtr.getHole();

            if (hole.getAssignedPlayer() == player) {
                hole.getSelectHole().setVisible(false);
            } else {
                hole.getSelectHole().setVisible(true);
            }
            hole.updateLabelAndButtonVisibility();
            curPtr = curPtr.getNextContainer();
        }

        if (tk.getTurnHaver() == player1) {
            player_two_indicator.setVisible(false);
            player_one_indicator.setVisible(true);
        } else {
            player_one_indicator.setVisible(false);
            player_two_indicator.setVisible(true);
        }
    }

    /**
     * Ends the current game when the player who cannot make any more moves (or a player that wants to give up) clicks
     * the "Forfeit Game" button on screen. Determines the winner through the determineWinLoss function on Game.
     * Returns to the Main/Administrator view, but does not destroy the singleton instance of game, meaning the winner/
     * loser can be extracted to do player win/loss ratio adjustments etc.
     * @param actionEvent
     * @throws IOException
     */
    public void endGame(ActionEvent actionEvent) throws IOException {
        Main.getCurrentGame().determineWinLoss();
        new SceneLoader("/view/testmain.fxml").load();
    }
}