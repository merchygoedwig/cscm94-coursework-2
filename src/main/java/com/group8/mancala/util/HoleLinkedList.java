package com.group8.mancala.util;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Player;

/**
 * Linked List implementation that allows all of the holes in the Mancala game to be accessed sequentially
 * @author Genevieve Clifford
 * @version InDev
 */
public class HoleLinkedList {
    private HoleContainer head = null;
    private HoleContainer tail = null;

    /**
     * Adds a new {@link Hole} to the end of the Linked List
     * @param hole {@link Hole} to add to the end of the list
     */
    public void addHole(Hole hole) {
        hole.setHll(this);
        HoleContainer newHoleContainer = new HoleContainer(hole);
        hole.setSituatedContainer(newHoleContainer);

        if (head == null) {
            head = newHoleContainer;
            tail = newHoleContainer;
        } else {
            tail.setNextContainer(newHoleContainer);
            tail = newHoleContainer;
        }
    }

    /**
     * Returns the {@link Hole} that belongs to {@link Player} that is of type
     * {@link com.group8.mancala.gameplayobjects.Hole.HoleType#MANCALA}
     * @param p {@link Player} to match on
     * @return that player's Hole that is a Mancala
     */
    public Hole getMancala(Player p) {
        HoleContainer curPtr = head;
        while (curPtr.getHole() != null) {
            Hole curHole = curPtr.getHole();
            if (curHole.gethType() == Hole.HoleType.MANCALA && curHole.getAssignedPlayer() == p) {
                return curHole;
            }
            curPtr = curPtr.getNextContainer();
        }
        throw new NullPointerException("No such hole found");
    }

    /**
     * Getter for the head of the list
     * @return head of the list
     */
    public HoleContainer getHead() {
        return head;
    }
}
