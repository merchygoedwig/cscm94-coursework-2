package com.group8.mancala.rule;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Player;

public class InventoryAction extends HandAction {
    private static final Hole hole = null;

    public InventoryAction(Player player) {
        super(player, hole);
    }

    @Override
    public Boolean checkValidity() {
        return null;
    }
}
