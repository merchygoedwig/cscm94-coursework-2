/**
FILENAME: MancalaImpl.java 
Defines a class Mancala which extends class HoleImpl and stores information about a manacala hole and player it is assigned to.
@author Paulina Mielewska
*/
package com.group8.mancala.gameplayobjects;

import com.group8.mancala.playerfacing.Player;

public class MancalaImpl extends HoleImpl implements Mancala {

  private static boolean isMancala;

  public MancalaImpl(Player player) {
    super(player, true);
  }

  /**
   * Method to check if the current hole is the mancala Hole.
   *
   * @return boolean isMancala which should be set in the input constructor as
   *         'False' for the holes other than Mancala hole.
   */
  @Override
  public boolean isMancala() {
    return isMancala;
  }
}