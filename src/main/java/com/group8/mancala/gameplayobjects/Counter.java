package com.group8.mancala.gameplayobjects;

/**
 * Class to implement the features of a counter (pebble, token, etc.) that you would find in a Mancala game
 * @author Genevieve Clifford
 * @version InDev
 */
public class Counter {
    private CounterType ct;

    public enum CounterType{
        REGULAR {
            @Override
            public String toString() {
                return "Regular";
            }
        },
        HALF_HAND {
            @Override
            public String toString() {
                return "Half Hand";
            }
        },
        REVERSE_TURN {
            @Override
            public String toString() {
                return "Reverse Turn";
            }
        },
        SWITCH_SIDES {
            @Override
            public String toString() {
                return "Switch Sides";
            }
        }
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
