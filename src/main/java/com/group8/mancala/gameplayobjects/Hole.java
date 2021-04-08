package com.group8.mancala.gameplayobjects;

import com.group8.mancala.playerfacing.Player;

public interface Hole {
    Player getAssignedPlayer();

    int getCounterCount();
}
