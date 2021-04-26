package com.group8.mancala.playerfacing;

import com.group8.mancala.Game;
import com.group8.mancala.GameController;
import com.group8.mancala.Main;
import com.group8.mancala.gameplayobjects.Counter;
import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.rule.DrawAction;
import com.group8.mancala.rule.InventoryAction;
import com.group8.mancala.rule.PlaceAction;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Stack;

public class Hand {
    private Player associatedPlayer;
    private Stack<Counter> countersInHand;
    private boolean continueTurn = false;
    private boolean continueTurnThisTurn = false;
    private boolean doublePoints = false;
    private boolean doublePointsThisTurn = false;
    private boolean halfHand = false;
    private boolean reverseTurn = false;
    private boolean switchSides = false;

    private Counter.CounterType[] counterChoices;

// These are extensions of the generic HandAction class that is used to determine if an action taken by a
    // hand is a valid one or not
//    private DrawAction da;
//    private InventoryAction ia;
//    private PlaceAction pa;

    public Hand(Player associatedPlayer) {
        this.associatedPlayer = associatedPlayer;

        countersInHand = new Stack<Counter>();
        counterChoices = new Counter.CounterType[30];

        int ptr = 0;

        for (int i = 0; i < 27; i++) {
            counterChoices[i] = Counter.CounterType.REGULAR;
            ptr++;
        }

        counterChoices[ptr] = Counter.CounterType.HALF_HAND;
        counterChoices[ptr + 1] = Counter.CounterType.REVERSE_TURN;
        counterChoices[ptr + 2] = Counter.CounterType.SWITCH_SIDES;


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

    public boolean isContinueTurnThisTurn() {
        return continueTurnThisTurn;
    }

    public void setContinueTurnThisTurn(boolean continueTurnThisTurn) {
        this.continueTurnThisTurn = continueTurnThisTurn;
    }

    public boolean isDoublePointsThisTurn() {
        return doublePointsThisTurn;
    }

    public void setDoublePointsThisTurn(boolean doublePointsThisTurn) {
        this.doublePointsThisTurn = doublePointsThisTurn;
    }

    public boolean isHalfHand() {
        return halfHand;
    }

    public void setHalfHand(boolean halfHand) {
        this.halfHand = halfHand;
    }

    public boolean isReverseTurn() {
        return reverseTurn;
    }

    public void setReverseTurn(boolean reverseTurn) {
        this.reverseTurn = reverseTurn;
    }

    public boolean isSwitchSides() {
        return switchSides;
    }

    public void setSwitchSides(boolean switchSides) {
        this.switchSides = switchSides;
    }

    /**
     * Accepts a counter into the Hand's Counter stack from a Hole
     * @param c counter to be accepted
     */
    public void acceptCounterIntoHand(Counter c) {
        if (Main.getCurrentGame().getGt() == Game.GameType.ARCADE) {
            Random random = new Random();
            int randInt = random.nextInt(counterChoices.length);
            Counter.CounterType chosenType = counterChoices[randInt];
            c = new Counter(chosenType);
            System.out.println(c);
        }

        handleSpecialCounter(c);
        countersInHand.push(c);
    }

    public void handleSpecialCounter(Counter c) {
        GameController gc = Main.getCurrentGame().getGc();
        Counter.CounterType ct = c.getCt();
        String fString = "%s activated %s";
        String returnedString = String.format(fString, associatedPlayer.getUsername(), ct);

        if (ct == Counter.CounterType.HALF_HAND) {
            setHalfHand(true);
            setSwitchSides(false);
            setReverseTurn(false);
        } else if (ct == Counter.CounterType.REVERSE_TURN) {
            setReverseTurn(true);
            setHalfHand(false);
            setSwitchSides(false);
        } else if (ct == Counter.CounterType.SWITCH_SIDES) {
            setSwitchSides(true);
            setHalfHand(false);
            setReverseTurn(false);
        }
        gc.last_power_up.setText(returnedString);
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

        if (isHalfHand()) {
            int amtInHand = countersInHand.size();
            int toRemainInHole = amtInHand / 2 - amtInHand % 2;

            for (int i = 1; i <= toRemainInHole; i++) {
                countersInHand.pop();
                curPtr.acceptCounter(new Counter(Counter.CounterType.REGULAR));
            }
        } else if (isReverseTurn()) {
            while (!countersInHand.empty()) {
                Hole seek = curPtr;
                Hole prev = curPtr;
                try {
                    curPtr = curPtr.getSituatedContainer().getNextContainer().getHole();
                } catch (NullPointerException e) {
                    curPtr = head;
                }

                while (curPtr != seek) {
                    prev = curPtr;
                    try {
                        curPtr = curPtr.getSituatedContainer().getNextContainer().getHole();
                    } catch (NullPointerException e) {
                        curPtr = head;
                    }
                }
                countersInHand.pop();
                curPtr.acceptCounter(new Counter(Counter.CounterType.REGULAR));
                hole.updateLabelAndButtonVisibility();
            }
        } else if (isSwitchSides()) {
            while (!countersInHand.empty()) {
                curPtr.acceptCounter(countersInHand.pop());
            }
            curPtr.updateLabelAndButtonVisibility();
            for (int i = 0; i < 7; i++) {
                try {
                    curPtr = curPtr.getSituatedContainer().getNextContainer().getHole();
                } catch (NullPointerException e) {
                    curPtr = head;
                }
            }
            curPtr.giveAllCountersToHand(this);
        }

        while (!countersInHand.empty()) {
            try {
                curPtr = curPtr.getSituatedContainer().getNextContainer().getHole();
            } catch (NullPointerException e) {
                curPtr = head;
            }
            countersInHand.pop();
            curPtr.acceptCounter(new Counter(Counter.CounterType.REGULAR));
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
