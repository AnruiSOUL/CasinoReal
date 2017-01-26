package com.casinoreal;

/**
 * Created by alexandraarmstrong on 1/24/17.
 */
abstract public class Game {
    protected double bet;
    protected Player player;

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    abstract public void startGame();

    abstract public boolean checkForWin();

    public double getBet(){
        return bet;
    }

    public void setBet(double bet){
        this.bet = bet;
        player.setBalance(player.getBalance() - getBet());
    }

}
