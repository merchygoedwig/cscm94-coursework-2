/**
FILENAME: /mancala.java 
Defines a class Mancala which stores information about a final mancala hole and counters it contains.
@author Paulina Mielewska
*/
package com.group8.mancala.gameplayobjects;


public interface Mancala extends Hole {
  boolean isMancala = true;
  
  private boolean isMancala() {
    return isMancala;
  }
  }


