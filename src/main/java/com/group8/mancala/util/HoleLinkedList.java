package com.group8.mancala.util;

import com.group8.mancala.gameplayobjects.Hole;

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
        HoleContainer newHoleContainer = new HoleContainer(hole);

        if (head == null) {
            head = newHoleContainer;
            tail = newHoleContainer;
        } else {
            tail.setNextContainer(newHoleContainer);
            tail = newHoleContainer;
        }
    }
}
