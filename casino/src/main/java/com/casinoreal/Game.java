package com.casinoreal;

/**
 * Created by alexandraarmstrong on 1/24/17.
 */
abstract public class Game {
    private double bet;

    //private I/O;

    abstract public Player startGame();

    abstract public void checkForWin();

    //public void quitGame(){}

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }
}
