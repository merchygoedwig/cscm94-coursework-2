package com.group8.mancala;

/**
 * com.group8.mancala.java.HoleAction is an implementation of the com.group8.mancala.java.Rule class for interactions
 * between instances of com.group8.mancala.java.Hole and com.group8.mancala.java.Player.
 */
abstract class HoleAction implements Rule {

    protected Player originator;
    protected Hole target;

    /**
     * Checks for if a rule is violated by a move or not
     * @return Boolean representation of the validity of a given rule given
     * the instance's originator (com.group8.mancala.java.Player) and target (com.group8.mancala.java.Hole) values.
     */
    abstract public Boolean checkValidity();

    /**
     * Sets a com.group8.mancala.java.Player for the com.group8.mancala.java.HoleAction
     * @param originatorCandidate com.group8.mancala.java.Player for which rules should be checked
     */
    public void setOriginator(Player originatorCandidate) {
        originator = originatorCandidate;
    }

    /**
     * Returns the com.group8.mancala.java.Player set in com.group8.mancala.java.HoleAction
     * @return com.group8.mancala.java.Player for which rules should be checked
     */
    public Player getOriginator() {
        return originator;
    }

    /**
     * Sets a com.group8.mancala.java.Hole for the com.group8.mancala.java.HoleAction
     * @param targetCandidate com.group8.mancala.java.Hole for which rules should be checked
     */
    public void setTarget(Hole targetCandidate) {
        target = targetCandidate;
    }

    /**
     * Returns the com.group8.mancala.java.Hole set in com.group8.mancala.java.HoleAction
     * @return com.group8.mancala.java.Hole for which rules should be checked
     */
    public Hole getTarget() { return target; }
}
