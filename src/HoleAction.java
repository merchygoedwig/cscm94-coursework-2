abstract class HoleAction implements Rule {
    protected Player originator;
    protected Hole target;

    abstract public Boolean checkValidity();

    public void setOriginator(Player originatorCandidate) {
        originator = originatorCandidate;
    }

    public Player getOriginator() {
        return originator;
    }

    public void setTarget(Hole targetCandidate) {
        target = targetCandidate;
    }

    public Hole getTarget() { return target; }
}
