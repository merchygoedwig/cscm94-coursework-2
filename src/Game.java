import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Game is the representation of the game of Mancala, it collaborates with Session. It is a singleton class, there
 * can only be one type of Game at any one time.
 *
 * @author Genevieve Clifford
 * @version 1.0
 */
public class Game {
    private ArrayList<Player> playersInGame;
    private Session currentSession;
    private int turnCount;
    private LinkedList<Hole> gameHoles;

    /**
     * Creates instance of Game, add players with setPlayersInGame()...
     */
    public Game() {}

    /**
     * Returns which players are "loaded" into the instance of Game
     * @return ArrayList of Players in the game
     */
    public ArrayList<Player> getPlayersInGame() {
        return playersInGame;
    }

    /**
     * Sets which players are to be "loaded" into the instance of Game
     * @param player1 The first player in Game
     * @param player2 The second player in Game
     */
    public void setPlayersInGame(Player player1, Player player2) {
        playersInGame.add(player1);
        playersInGame.add(player2);
    }

    /**
     * Increments the turn counter for the current instance of Game
     */
    public void incrementTurnCount() {
        turnCount++;
    }
}
