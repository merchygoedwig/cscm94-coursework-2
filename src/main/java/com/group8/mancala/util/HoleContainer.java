package com.group8.mancala.util;

import com.group8.mancala.gameplayobjects.Hole;

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

