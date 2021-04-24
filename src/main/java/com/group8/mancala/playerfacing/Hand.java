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
    // These are extensions of the generic HandAction class that is used to determine if an action taken by a
    // hand is a valid one or not
    private DrawAction da;
    private InventoryAction ia;
    private PlaceAction pa;

    public Hand(Player associatedPlayer) {
        this.associatedPlayer = associatedPlayer;

        countersInHand = new Stack<Counter>();

        da = new DrawAction(this.associatedPlayer);
        ia = new InventoryAction(this.associatedPlayer);
        pa = new PlaceAction(this.associatedPlayer);
    }

//    public void receiveFromHole(Hole hole) {
//        ia.setTarget(hole);
//        if (ia.checkValidity()) {
//            while (hole.getCounterCount() > 0) {
//                countersInHand.push(hole.giveUpCounter());
//                hole.updateLabel();
//            }
//        } else {
//            System.err.println("Requested to give up counters, but target was not valid!");
//        }
//    }

    public void acceptCounterIntoHand(Counter c) {
        countersInHand.push(c);
    }

    public void distributeCounters(Hole hole) {
        Hole curPtr = hole;
        Hole head = hole.getHll().getHead().getHole();

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

        if (!(curPtr.gethType() == Hole.HoleType.MANCALA && curPtr.getAssignedPlayer() == associatedPlayer)) {
            tk.nextTurn();
        }
    }
}
