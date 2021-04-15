package com.group8.mancala.gameplayobjects;

import java.util.*;
public interface Hole {
  public Player assignedPlayer1;
  public Player assignedPlayer2;
  public Stack<Counter> counters = new Stack<>();
  public int counterAmount;
  public static boolean flag = true;

  public boolean isMancala();
  public void acceptCounter(Counter counter);
  public Stack<Counter> giveUpCounter();
  public int getCounterCount();
  public Player getAssignedPlayer();
}
