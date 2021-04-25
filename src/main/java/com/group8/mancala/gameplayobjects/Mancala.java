package com.group8.mancala.gameplayobjects;

import com.group8.mancala.playerfacing.Player;
import javafx.scene.text.Text;

import java.util.Stack;

/**
 * Class representing Mancala in a Mancala game
 * @deprecated
 * This class is no longer used to represent a Mancala! This will be removed during the Arcade implementation!
 * <p>Use the enum {@link com.group8.mancala.gameplayobjects.Hole.HoleType} instead!</p>
 */
@Deprecated(forRemoval = true)
public class Mancala extends Hole {
    private Stack<Counter> counters;
    private Player assignedPlayer;
    private Text counterDisplay;

    public Mancala (Player assignedPlayer, Text displayCounters) {
        counterDisplay = displayCounters;
        this.assignedPlayer = assignedPlayer;
        counters = new Stack<Counter>();
    }
}
