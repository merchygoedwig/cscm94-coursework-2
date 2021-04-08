package com.group8.mancala.rule;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Player;

public class DrawAction extends HandAction {

    public DrawAction(Player player, Hole hole) {
        super(player, hole);
    }

    @Override
    public Boolean checkValidity() {
        return null;
    }
}
