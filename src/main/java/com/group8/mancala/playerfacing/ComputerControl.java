package com.group8.mancala.playerfacing;

import com.group8.mancala.Game;
import com.group8.mancala.GameController;
import com.group8.mancala.Main;
import com.group8.mancala.gameplayobjects.Hole;
import com.group8.mancala.util.HoleContainer;
import com.group8.mancala.util.HoleLinkedList;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class for controlling a computer based player
 * @author Genevieve Clifford
 * @version InDev
 */
public class ComputerControl {
    private Player correspondingPlayer;
    private Hole[] legalMoves;
    private GameController gc;
    private Random random = new Random();

    public ComputerControl() {
        this.gc = Main.getCurrentGame().getGc();
        legalMoves = gc.getComputerHoles();
    }

    public void performRandomLegalMove() {
        int noHoles = legalMoves.length;
        System.out.println(noHoles);

        for (Hole h : legalMoves) {
            System.out.println(h);
        }

        Hole randomHole = legalMoves[random.nextInt(noHoles)];

        System.out.println(randomHole);

        randomHole.giveAllCountersToHand(correspondingPlayer.getHand());
    }
}
