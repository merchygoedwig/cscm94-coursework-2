/**
 * HoleAction is an implementation of the Rule class for interactions
 * between instances of Hole and Player.
 */
abstract class HoleAction implements Rule {

    protected Player originator;
    protected Hole target;

    /**
     * Checks for if a rule is violated by a move or not
     * @return Boolean representation of the validity of a given rule given
     * the instance's originator (Player) and target (Hole) values.
     */
    abstract public Boolean checkValidity();

    /**
     * Sets a Player for the HoleAction
     * @param originatorCandidate Player for which rules should be checked
     */
    public void setOriginator(Player originatorCandidate) {
        originator = originatorCandidate;
    }

    /**
     * Returns the Player set in HoleAction
     * @return Player for which rules should be checked
     */
    public Player getOriginator() {
        return originator;
    }

    /**
     * Sets a Hole for the HoleAction
     * @param targetCandidate Hole for which rules should be checked
     */
    public void setTarget(Hole targetCandidate) {
        target = targetCandidate;
    }

    /**
     * Returns the Hole set in HoleAction
     * @return Hole for which rules should be checked
     */
    public Hole getTarget() { return target; }
}
