package com.group8.mancala.util;

import com.group8.mancala.gameplayobjects.Hole;

/**
 * Wrapper class for Hole, this is just a very thin layer that provides information to other classes about the
 * way in which Holes are arranged in a Linked List
 * @author Genevieve Clifford
 * @version InDev
 */
public class HoleContainer {
    private Hole hole;
    private HoleContainer nextContainer;

    public HoleContainer(Hole hole) {
        this.hole = hole;
    }

    public Hole getHole() {
        return hole;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    public HoleContainer getNextContainer() {
        return nextContainer;
    }

    public void setNextContainer(HoleContainer nextContainer) {
        this.nextContainer = nextContainer;
    }
}

