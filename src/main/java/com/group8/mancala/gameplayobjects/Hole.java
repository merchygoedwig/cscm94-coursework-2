package com.group8.mancala.gameplayobjects;

import java.text.ParseException;
import java.util.*;

import com.group8.mancala.playerfacing.Player;

public interface Hole {

  Stack<Counter> counters = new Stack<>();

  void acceptCounter(Counter counter);

  Stack<Counter> giveUpCounter() throws ParseException;

  int getCounterCount() throws ParseException;

  Player getAssignedPlayer() throws ParseException;

}