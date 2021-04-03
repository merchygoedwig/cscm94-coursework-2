import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private ArrayList<Player> playersInGame;
    private Session currentSession;
    private int turnCount;
    private LinkedList<Hole> gameHoles;

    public ArrayList<Player> getPlayersInGame() {
        return playersInGame;
    }

    public void setPlayersInGame(Player player1, Player player2) {
        playersInGame.add(player1);
        playersInGame.add(player2);
    }

    public void incrementTurnCount() {
        turnCount++;
    }
}
