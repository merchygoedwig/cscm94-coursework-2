package com.group8.mancala.playerfacing;

import com.group8.mancala.Game;
import com.group8.mancala.Main;
import com.group8.mancala.gameplayobjects.Counter;
import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.rule.DrawAction;
import com.group8.mancala.rule.InventoryAction;
import com.group8.mancala.rule.PlaceAction;

import java.util.Stack;

public class Hand {
    private Player associatedPlayer;
    private Stack<Counter> countersInHand;
    private boolean continueTurn = false;
    private boolean doublePoints = false;


// These are extensions of the generic HandAction class that is used to determine if an action taken by a
    // hand is a valid one or not
//    private DrawAction da;
//    private InventoryAction ia;
//    private PlaceAction pa;

    public Hand(Player associatedPlayer) {
        this.associatedPlayer = associatedPlayer;

        countersInHand = new Stack<Counter>();

//        Not actually implemented yet! Will be for the arcade mode :3

//        da = new DrawAction(this.associatedPlayer);
//        ia = new InventoryAction(this.associatedPlayer);
//        pa = new PlaceAction(this.associatedPlayer);
    }

    public boolean usedContinueTurn() {
        return continueTurn;
    }

    public void setContinueTurn(boolean continueTurn) {
        this.continueTurn = continueTurn;
    }

    public boolean usedDoublePoints() {
        return doublePoints;
    }

    public void setDoublePoints(boolean doublePoints) {
        this.doublePoints = doublePoints;
    }

    /**
     * Accepts a counter into the Hand's Counter stack from a Hole
     * @param c counter to be accepted
     */
    public void acceptCounterIntoHand(Counter c) {
        countersInHand.push(c);
    }

    /**
     * Distributes counters through the HoleLinkedList in the game, according to the rules given in the specification
     * @param hole the hole for which the distributeCounters action was triggered on
     */
    public void distributeCounters(Hole hole) {
        Hole curPtr = hole;
        Hole head = hole.getHll().getHead().getHole();

        // Moves through all the Holes in the linked list, if it hits the end, it goes back to the beginning, will
        // continue to distribute counters until the stack in the hand is empty
        while (!countersInHand.empty()) {
            try {
                curPtr = curPtr.getSituatedContainer().getNextContainer().getHole();
            } catch (NullPointerException e) {
                curPtr = head;
            }
            curPtr.acceptCounter(countersInHand.pop());
            hole.updateLabelAndButtonVisibility();
        }
        Game.TurnKnower tk = Main.getCurrentGame().getTk();

        // If the hole that the last counter was placed into was the player's mancala, they get another turn, hence
        // here we update TurnKnower accordingly to get our next turn
        if (!(curPtr.gethType() == Hole.HoleType.MANCALA && curPtr.getAssignedPlayer() == associatedPlayer)) {
            tk.nextTurn();
        }
    }
}
