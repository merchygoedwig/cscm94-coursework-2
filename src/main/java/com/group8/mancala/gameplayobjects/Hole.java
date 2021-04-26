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
  private HoleLinkedList hll;
  private HoleContainer situatedContainer;

  public enum HoleType {
    HOLE,
    MANCALA
  }

  /**
   * Constructor for Hole
   * @param playerToAssign the player who the hole is associate with (i.e. same side of board as player)
   * @param displayCounter instance of JavaFX text showing the number of counters in the hole
   * @param button button that selects the hole (scoops up all of the Counters into the Player's Hand)
   * @param ht either Hole.HoleType.HOLE or Hole.HoleType.MANCALA (sets whether the hole is a normal hole or a mancala)
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
        counters.push(new Counter(Counter.CounterType.REGULAR));
      }
    }

    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        giveAllCountersToHand();
      }
    });
  }

  /**
   * Do not use this constructor, this has to be here or JavaFX will complain
   */
  public Hole() { }

  /**
   * Gives the HoleContainer that the instance of Hole "sits" in
   * @return surrounding HoleContainer
   */
  public HoleContainer getSituatedContainer() {
    return situatedContainer;
  }

  /**
   * Sets the HoleContainer that the instance of Hole "sits" in
   * @param situatedContainer HoleContainer that the instance of Hole "sits" in
   */
  public void setSituatedContainer(HoleContainer situatedContainer) {
    this.situatedContainer = situatedContainer;
  }

  /**
   * Gives the enum HoleType that the Hole is assigned
   * @return HoleType of the Hole
   */
  public HoleType gethType() {
    return hType;
  }

  /**
   * Gets the singleton instance of HoleLinkedList that the Hole resides in
   * @return Game's HoleLinkedList
   */
  public HoleLinkedList getHll() {
    return hll;
  }

  /**
   * Gets the singleton instance of HoleLinkedList that the Hole resides in
   * @param hll HoleLinkedList that the Hole resides in
   */
  public void setHll(HoleLinkedList hll) {
    this.hll = hll;
  }

  /**
   * Gets the button that is used to perform the player's action (selecting a Hole to take counters from)
   * @return
   */
  public Button getSelectHole() {
    return selectHole;
  }

  /**
   * Accepts new counters that are added to a Hole during the game.
   *
   * @param someCounter Counter that has been moved from another Hole
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

  /**
   * Wrapper overload for function of same name, specifies hand from that belonging to the current hole instead
   */
  public void giveAllCountersToHand() {
    Hand hand = assignedPlayer.getHand();
    giveAllCountersToHand(hand);
  }

  /**
   * Gives all the counters in the hole's stack to the hand that has requested them
   * @param hand the hand to give all counters in a stack to
   */
  public void giveAllCountersToHand(Hand hand) {
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
   * @return An integer representing the number of counters in a hole.
   */
  public int getCounterCount() {
    return counters.size();
  }

  /**
   * Method to update the label and button for each hole corresponding to both current turn and the number of counters
   * in the hole
   */
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

  /**
   * Returns a string representing the state of the hole
   * @return string interpretation of hole
   */
  public String toString() {
    return assignedPlayer.getUsername() + getCounterCount() + gethType();
  }
}