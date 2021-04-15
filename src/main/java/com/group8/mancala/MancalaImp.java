/**
FILENAME: Mancala.java 
Defines a class Mancala which extends class Hole and stores information about a manacala hole and player it is assigned to.
@author Paulina Mielewska
*/
package com.group8.mancala.gameplayobjects;

import java.util.*;

public class MancalaImp implements Mancala {

  private boolean isMancala;
  
  public MancalaImp(Player player, boolean isMancala) {
    super(player, isMancala);
    this.player = player;
  }

  /**
   * Method to check if the current hole is the mancala Hole.
   *
   * @return boolean isMancala which should be set in the input constructor as 'False' for the holes other than Mancala hole.
   */  
  public boolean isMancala() {
    return isMancala;
  }
}