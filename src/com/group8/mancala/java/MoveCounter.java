package com.group8.mancala.java;

/**
 * com.group8.mancala.java.MoveCounter extends the com.group8.mancala.java.HoleAction abstract class and implements
 * rule actions for interactions involving a com.group8.mancala.java.Player moving Counters
 * into a com.group8.mancala.java.Hole.
 *
 * @author Genevieve Clifford
 * @version 1.0
 */
public class MoveCounter extends HoleAction {
    /**
     * Default constructor for com.group8.mancala.java.MoveCounter, this is to be used in the context
     * of a Hand belonging to a com.group8.mancala.java.Player (each Hand will have an instance of
     * com.group8.mancala.java.MoveCounter for checking valid moves).
     * @param player the instance of com.group8.mancala.java.Player that originated the action
     * @param hole the hole which a com.group8.mancala.java.Player has targeted
     */
    public MoveCounter(Player player, Hole hole) {
        originator = player;
        target = hole;
    }

    private Boolean targetBelongsToPlayer(Player originator, Hole target) {
        return originator == target.getAssignedPlayer();
    }

    private Boolean targetHasCounters(Hole target) {
        return target.getCounterCount() > 0;
    }

    private Boolean targetNotMancala(Hole target) {
        return !(target instanceof Mancala);
    }

    /**
     * Checks if a move in the instance of com.group8.mancala.java.MoveCounter is a valid move that
     * can be made at that time.
     * @return Boolean of if counters are allowed to be moved from a com.group8.mancala.java.Hole by
     * a given com.group8.mancala.java.Player.
     */
    @Override
    public Boolean checkValidity() {
        return (
                targetBelongsToPlayer(originator, target) &&
                        targetHasCounters(target) &&
                        targetNotMancala(target)
                );
    }
}
