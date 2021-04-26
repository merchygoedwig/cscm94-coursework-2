package com.group8.mancala.gameplayobjects;

/**
 * Class to implement the features of a counter (pebble, token, etc.) that you would find in a Mancala game
 * @author Genevieve Clifford
 * @version InDev
 */
public class Counter {
    private CounterType ct;

    public enum CounterType{
        REGULAR,
        HALF_HAND,
        REVERSE_TURN,
        SWITCH_SIDES
    }

    public Counter(CounterType ct) {
        this.ct = ct;
    }

    public CounterType getCt() {
        return ct;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "ct=" + ct +
                '}';
    }
}
