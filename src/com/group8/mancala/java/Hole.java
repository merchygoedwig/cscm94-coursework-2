/**
FILENAME: Hole.java 
Defines a class, Hole, to store information about a single hole and counters it contains.
@author Paulina Mielewska
*/
package com.group8.mancala.gameplayobjects;

import java.util.*;
import com.group8.mancala.playerfacing.Player;

public interface Hole {
  private Player assignedPlayer;
  private Stack<Counter> counters;
  int counterAmount;

  /**
   * Counstructor.
   *
   * @param initialAmount initial number of counters in a hole
   * @return Hole for which we set initial amount of counters
   */
  public Hole(int initialAmount) {
    counterAmount = initialAmount;
  }
  /**
   * Accepts new counters that are added to a Hole during the game.
   *
   * @param someCounter Counter thats has been moved from other Hole
   */   
  private void acceptCounter(Counter someCounter) {
    Counter counter= new Counter(someCounter);
    counters.push(counter);
    counterAmount++;
  }
  
  /**
   * Remove all counters from a hole.
   */
  private void giveUpCounter() {
    counterAmount = 0;
  }

  /**
   * Returns the number of counters in a given hole.
   *
   * @return An int representing the number of counters in a hole.
   */
  public int getCounterCount() {
    return counterAmount;
  }
  /**
   * Method to return the current player that can play and move the counters from the current hole.
   *
   * @return Player that has been assigned to the part of the board with the Hole.
   */  
  public Player getAssignedPlayer() {
    return assigned Player;   
  }
}