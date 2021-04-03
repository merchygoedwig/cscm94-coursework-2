/**
 * MoveCounter extends the HoleAction abstract class and implements
 * rule actions for interactions involving a Player moving Counters
 * into a Hole.
 *
 * @author Genevieve Clifford
 * @version 1.0
 */
public class MoveCounter extends HoleAction {
    /**
     * Default constructor for MoveCounter, this is to be used in the context
     * of a Hand belonging to a Player (each Hand will have an instance of
     * MoveCounter for checking valid moves).
     * @param player the instance of Player that originated the action
     * @param hole the hole which a Player has targeted
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
     * Checks if a move in the instance of MoveCounter is a valid move that
     * can be made at that time.
     * @return Boolean of if counters are allowed to be moved from a Hole by
     * a given Player.
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
