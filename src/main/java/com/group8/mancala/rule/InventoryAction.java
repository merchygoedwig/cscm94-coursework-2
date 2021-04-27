package com.group8.mancala.rule;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Player;

/**
 * @author Genevieve Clifford
 * @version 1.0
 * @deprecated
 * Rules implemented in {@link com.group8.mancala.GameController} instead
 */
@Deprecated
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
