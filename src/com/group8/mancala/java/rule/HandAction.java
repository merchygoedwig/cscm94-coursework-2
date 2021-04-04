package com.group8.mancala.java.rule;

import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.gameplayobjects.Mancala;
import com.group8.mancala.playerfacing.Player;

/**
 * HoleAction is an implementation of the Rule class for interactions between instances of Hole and Player.
 */
abstract class HandAction implements Rule {

    protected Player originator;
    protected Hole target;

    public HandAction(Player player, Hole hole) {
        originator = player;
        target = hole;
    }

    /**
     * A check for ascertaining if a target Hole "belongs" to the opponent (the Player
     * that isn't the current one). This means it is on the same side of the board
     * as the opponent.
     *
     * @param originator The Player for whom the Hole is to be checked against
     * @param target     The Hole to check
     * @return Boolean value of whether the Hole belongs to the Player
     */
    protected Boolean targetBelongsToOpponent(Player originator, Hole target) {
        return originator != target.getAssignedPlayer();
    }

    /**
     * A check for ascertaining if the target Hole has one or many counters
     *
     * @param target The Hole to check
     * @return Boolean value of whether the Hole has one or many counters
     */
    protected Boolean targetHasCounters(Hole target) {
        return target.getCounterCount() > 0;
    }

    /**
     * A check for ascertaining if the target subclasses Hole (i.e. is an instance of
     * Mancala).
     *
     * @param target The Hole to check
     * @return Boolean value of whether the Hole is a Mancala or not
     */
    protected Boolean targetIsMancala(Hole target) {
        return !(target instanceof Mancala);
    }

    /**
     * Checks for if a rule is violated by a move or not
     *
     * @return Boolean representation of the validity of a given rule given
     * the instance's originator (Player) and target (Hole) values.
     */
    abstract public Boolean checkValidity();

    /**
     * Sets a Player for the HoleAction
     *
     * @param originatorCandidate Player for which rules should be checked
     */
    public void setOriginator(Player originatorCandidate) {
        originator = originatorCandidate;
    }

    /**
     * Returns the Player set in HoleAction
     *
     * @return Player for which rules should be checked
     */
    public Player getOriginator() {
        return originator;
    }

    /**
     * Sets a Hole for the HoleAction
     *
     * @param targetCandidate Hole for which rules should be checked
     */
    public void setTarget(Hole targetCandidate) {
        target = targetCandidate;
    }

    /**
     * Returns the Hole set in HoleAction
     *
     * @return Hole for which rules should be checked
     */
    public Hole getTarget() {
        return target;
    }
}
