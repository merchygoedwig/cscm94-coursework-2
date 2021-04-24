package com.group8.mancala.gameplayobjects;

import com.group8.mancala.playerfacing.Player;
import javafx.scene.text.Text;

import java.util.Stack;

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
