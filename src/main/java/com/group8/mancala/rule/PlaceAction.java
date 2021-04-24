package com.group8.mancala.rule;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.playerfacing.Player;

/**
 * MoveCounter extends the HoleAction abstract class and implements
 * rule actions for interactions involving a Player placing Counters
 * into a Hole.
 *
 * @author Genevieve Clifford
 * @version 1.0
 */
public class PlaceAction extends HandAction {
    /**
     * Default constructor for MoveAction, this is to be used in the context
     * of a Hand belonging to a Player (each Hand will have an instance of
     * MoveCounter for checking valid moves).
     *
     * @param player the instance of Player that originated the action
     * @param hole   the hole which a Player has targeted
     */
    public PlaceAction(Player player, Hole hole) {
        super(player, hole);
    }

    public PlaceAction(Player player) {
        super(player);
    }

    /**
     * A counter cannot be placed into a hole if both: the hole is a Mancala AND
     * the Hole "belongs" to the opponent. Every other case is allowable. Here
     * we are performing this by doing ~targetBelongsToOpponent(originator, target) &
     * ~targetIsMancala(target)
     *
     * @return Boolean of if counters are allowed to be placed into a Hole by
     * a given Player.
     */
    @Override
    public Boolean checkValidity() {
        return !(targetBelongsToOpponent(originator, target) && targetIsMancala(target));
    }
}
