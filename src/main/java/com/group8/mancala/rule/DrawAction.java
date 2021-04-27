package com.group8.mancala.rule;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Player;

/**
 * Rules to be checked on the draw of a counter
 * @author Genevieve Clifford
 * @version 1.0
 * @deprecated
 * Rules implemented in {@link com.group8.mancala.GameController} instead
 */
@Deprecated
public class DrawAction extends HandAction {
    public DrawAction(Player player, Hole hole) {
        super(player, hole);
    }

    public DrawAction(Player player) {
        super(player);
    }

    @Override
    public Boolean checkValidity() {
        return null;
    }
}
