/**
FILENAME: HoleImpl.java 
Defines a class Hole which extends class Mancala to store information about a single hole, counters it contains and assigned player.
It contains an additional method 
@author Paulina Mielewska
*/
package com.group8.mancala.gameplayobjects;

import com.group8.mancala.playerfacing.Player;
import java.text.ParseException;
import java.util.EmptyStackException;
import java.util.Stack;

public class HoleImpl implements Hole {
  private Player assignedPlayer;
  private Stack<Counter> counters;

  public HoleImp() {
    counters = new Stack<Counter>();
  }

  public HoleImp(Player player, boolean mancala) {
    // this.counterAmount = initialAmount;
    this.assignedPlayer = player;
  }

  /**
   * Accepts new counters that are added to a Hole during the game.
   *
   * @param someCounter single counter that has been added from the Hand to the
   *                    Stack counter.
   */
  @Override
  public void acceptCounter(Counter counter) {
    counters.push(counter);
  }

  /**
   * Counters from the Stack are copied to the temporary array. This new array is
   * then cleared.
   * 
   * @return Stack<Counter> an empty temporary Stack
   */
  @Override
  public Stack<Counter> giveUpCounter() throws ParseException {
    if (counters.size() > 0) {
      Stack<Counter> tempStack = new Stack<Counter>();
      tempStack.addAll(counters);
      counters.clear();
      return tempStack;
    } else {
      throw new EmptyStackException();
    }
  }

  /**
   * Returns the number of counters in a given hole.
   *
   * @return An int representing the number of counters in a hole.
   */
  @Override
  public int getCounterCount() throws ParseException {
    return counters.size();
  }

  /**
   * Method to return the current player that can play and move the counters from
   * the current hole.
   *
   * @return Player that has been assigned to the part of the board with the Hole.
   */

  public Player getAssignedPlayer() throws ParseException {
    return assignedPlayer;
  }
}