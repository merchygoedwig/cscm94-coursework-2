public class MoveCounter extends HoleAction {

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

    @Override
    public Boolean checkValidity() {
        return (
                targetBelongsToPlayer(originator, target) &&
                        targetHasCounters(target) &&
                        targetNotMancala(target)
                );
    }
}
