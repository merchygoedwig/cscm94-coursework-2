package com.group8.mancala.util;

import com.group8.mancala.gameplayobjects.Hole;

/**
 * Linked List implementation that allows all of the holes in the Mancala game to be accessed sequentially
 * @author Genevieve Clifford
 * @version InDev
 */
public class HoleLinkedList {
    private HoleContainer head = null;
    private HoleContainer tail = null;

    public HoleContainer getHead() {
        return head;
    }

    public void setHead(HoleContainer head) {
        this.head = head;
    }

    public HoleContainer getTail() {
        return tail;
    }

    public void setTail(HoleContainer tail) {
        this.tail = tail;
    }

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
}
