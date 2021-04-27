package com.group8.mancala.rule;

/**
 * Rules are used to check the validity of moves during a game, each action
 * is associated with a com.group8.mancala.Rule.Rule (or sub-set of it).
=======
package com.group8.mancala;

/**
 * Rules are used to check the validity of moves during a game, each action
 * is associated with a com.group8.mancala.java.Rule (or sub-set of it).
 *
 * @author Genevieve Clifford
 * @version 1.0
 * @deprecated
 * Rules implemented in {@link com.group8.mancala.GameController} instead
 */
@Deprecated
public interface Rule {
    /**
     * Checks for if a rule is violated by a move or not
     *
     * @return Boolean representation of the validity of a given rule given
     * the instance's originator and target values.
     */
    Boolean checkValidity();
}
