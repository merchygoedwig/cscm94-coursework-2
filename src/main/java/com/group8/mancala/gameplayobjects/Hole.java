package com.group8.mancala.gameplayobjects;

import java.util.*;

import com.group8.mancala.Game;
import com.group8.mancala.Main;
import com.group8.mancala.playerfacing.Hand;
import com.group8.mancala.playerfacing.Player;
import com.group8.mancala.util.HoleContainer;
import com.group8.mancala.util.HoleLinkedList;
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
  private HoleType hType;
  private Game.TurnKnower tk;

  public enum HoleType {
    HOLE,
    MANCALA
  }

  public HoleType gethType() {
    return hType;
  }

  public HoleLinkedList getHll() {
    return hll;
  }

  public void setHll(HoleLinkedList hll) {
    this.hll = hll;
  }

  private HoleLinkedList hll;
  private HoleContainer situatedContainer;


  public HoleContainer getSituatedContainer() {
    return situatedContainer;
  }

  public void setSituatedContainer(HoleContainer situatedContainer) {
    this.situatedContainer = situatedContainer;
  }

  /**
   * Constructor.
   *
   */
  public Hole(Player playerToAssign, Text displayCounter, Button button, HoleType ht) {
    selectHole = button;
    counterDisplay = displayCounter;
    assignedPlayer = playerToAssign;
    counters = new Stack<Counter>();
    this.hType = ht;
    this.tk = Main.getCurrentGame().getTk();

    if (hType == HoleType.HOLE) {
      for (int i = 0; i < 4; i++) {
        counters.push(new Counter());
      }
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
  public void acceptCounter(Counter someCounter) {
    counters.push(someCounter);
    updateLabelAndButtonVisibility();
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
      this.updateLabelAndButtonVisibility();
    }
    hand.distributeCounters(this);
    this.updateLabelAndButtonVisibility();
  }

  /**
   * Returns the number of counters in a given hole.
   *
   * @return An int representing the number of counters in a hole.
   */
  public int getCounterCount() {
    return counters.size();
  }

  public void updateLabelAndButtonVisibility(String someText) {
    counterDisplay.setText(someText);
  }

  public void updateLabelAndButtonVisibility() {
    String counterString = String.valueOf(getCounterCount());
    counterDisplay.setText(counterString);
    if (getCounterCount() == 0 && tk.getTurnHaver() == assignedPlayer) {
      selectHole.setVisible(false);
    } else if (getCounterCount() > 0 && tk.getTurnHaver() == assignedPlayer) {
      selectHole.setVisible(true);
    }
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