package com.group8.mancala.gameplayobjects;

import java.util.*;

import com.group8.mancala.playerfacing.Hand;
import com.group8.mancala.playerfacing.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FILENAME: Hole.java
 * Defines a class, Hole, to store information about a single hole and counters it contains.
 * @author Paulina Mielewska and Genevieve Clifford
 * @version InDev
 */
public class Hole {
  private Player assignedPlayer;
  private Stack<Counter> counters;
  private Button selectHole;
  private Text counterDisplay;

  /**
   * Constructor.
   *
   */
  public Hole(Player playerToAssign, Text displayCounter, Button button) {
    selectHole = button;
    counterDisplay = displayCounter;
    assignedPlayer = playerToAssign;
    counters = new Stack<Counter>();
    for (int i = 0; i < 4; i++) {
      counters.push(new Counter());
    }

    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        giveAllCountersToHand();
      }
    });
  }

  public Hole() {

  }

  public Button getSelectHole() {
    return selectHole;
  }

  public void setSelectHole(Button selectHole) {
    this.selectHole = selectHole;
  }

  /**
   * Accepts new counters that are added to a Hole during the game.
   *
   * @param someCounter Counter thats has been moved from other Hole
   */   
  private void acceptCounter(Counter someCounter) {
    counters.push(someCounter);
  }
  
  /**
   * Remove a counter from a hole.
   */
  public Counter giveUpCounter() {
    return counters.pop();
  }

  public void giveAllCountersToHand() {
    Hand hand = assignedPlayer.getHand();
    while (!counters.empty()) {
      hand.acceptCounterIntoHand(counters.pop());
      this.updateLabel();
    }
  }

  /**
   * Returns the number of counters in a given hole.
   *
   * @return An int representing the number of counters in a hole.
   */
  public int getCounterCount() {
    return counters.size();
  }

  public void updateLabel(String someText) {
    counterDisplay.setText(someText);
  }

  public void updateLabel() {
    String counterString = String.valueOf(getCounterCount());
    counterDisplay.setText(counterString);
  }

  /**
   * Method to return the current player that can play and move the counters from the current hole.
   *
   * @return Player that has been assigned to the part of the board with the Hole.
   */  
  public Player getAssignedPlayer() {
    return assignedPlayer;
  }
}