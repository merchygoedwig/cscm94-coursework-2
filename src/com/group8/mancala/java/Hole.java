package com.group8.mancala.java;
/**
FILENAME: Hole.java 
Defines a class, Hole, to store information about a single hole and counters it contains.
@author Paulina Mielewska
*/

import java.util.*;

public interface Hole {
    private Player assignedPlayer;
    private Vector<Counter> counters;
    boolean isMancala;
    int counterAmount;
  
    /**
     * Counstructor.
     * @param initialAmount initial number of counters in a hole
     */
    public Hole(int initialAmount) {
      counterAmount = initialAmount;
    }
      
    private void acceptCounter(Counter someCounter) {
      Counter counter= new Counter(someCounter);
      counters.push(counter);
      counterAmount++;
      }
    }
    //remove all counters from a hole?? void type instead of Counter
    /**
     * Remove all counters from a hole.
     */
    private Counter giveUpCpunter() {
      counters.clear();
      counterAmount = 0;
    }
  
    private Hole antiClockwisetNextHole() {
          
    }
  
    private Hole antiClockwisetPrevHole() {
      while (counterAmount > 0) {
        counters.push(new Counter());
        counterAmount--;
      }
    }
    /**
     * Returns the number of counters in a given hole.
     * @return An int representing the number of counters in a hole.
     */
    public int getCounterCount() {
      return counterAmount;
    }
    /**
     * Changes Hole to Mancala (the final Hole)
     */
    private boolean changeCounterType() {
      return isMancala == true;
    }
}
