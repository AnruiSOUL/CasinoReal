package com.casinoreal;
import  java.util.ArrayList;
/**
 * Created by randallcrame on 1/24/17.
 */
public class BlackJack {
    private Shoe blackJack = new Shoe(3); //Shoe Object
    private int playerHandValue;
    private int dealerHandValue;
    private double bet;
    private double secondBet;
    private double payout = 2.0;
    private double naturalBlackJackPayout = 2.5;
    protected ArrayList<Card> playerHand = new ArrayList<>();
    private ArrayList<Card> player2ndHand = new ArrayList<>();
    protected ArrayList<Card> dealerHand = new ArrayList<>();
    private ArrayList<ArrayList<Card>> membersInGame = new ArrayList();
    private int numberOfAces;


    private void addMemberToGame(ArrayList member){
        this.membersInGame.add(member);
    }

    protected void joinMembersInGame(){
        addMemberToGame(playerHand);
        addMemberToGame(dealerHand);
        // will add function to add NPCs
    }

    private void dealFromShoe(ArrayList currentMember){
        currentMember.add(blackJack.drawCard());
    }

    protected void dealToPlayers(){
        for (int i =0; i<2; i++) {
            for (ArrayList member : this.membersInGame) {
                dealFromShoe(member);
            }
        }
    }

    protected void setWager(Player player ,double bet){
        //Set Bet
        this.bet = bet;
        player.updateBalance(-bet);
    }


    protected void hit(ArrayList currentMember){
        //Command requesting another card
        dealFromShoe(currentMember);
    }

    private void stay(){
       // break;
    }

    private void doubleDown(ArrayList currentMember){
        // raises bets 2x the amount
        this.bet += this.bet;
        dealFromShoe(currentMember);
        // Command ends turn
        // stay();
    }
    private void splitHand(ArrayList currentPlayer, ArrayList secondHand){
        secondHand.add(1, currentPlayer);
        currentPlayer.remove(1);
    }
    private void splitBet(ArrayList currentHand, ArrayList secondHand){
        // raises bets to another pot of the same bet
        this.secondBet = this.bet;
        splitHand(currentHand, secondHand);
        // deals 2nd card to new hands
        dealFromShoe(currentHand);
        dealFromShoe(secondHand);
        // flag so no further splits can occur
    }

    private boolean isSplittable(ArrayList card1, ArrayList card2){
        //checks to see if starting hand is splittable 2
        return (card1 == card2);
    }

    private int getCardValue(Card card) {
        int cardValue;
        String cardRank = card.getRank().toString();
        if (cardRank.equals('K') || cardRank.equals('Q') || cardRank.equals('J'))
            cardValue = 10;
        else if (!(cardRank.equals('A'))) {
            cardValue = Integer.parseInt(cardRank);
            numberOfAces++;
        } else
            cardValue = 11;
        return cardValue;
    }

    private int setHandValue(ArrayList<Card> playerHand, int handValue) {
        for (Card card:playerHand) {
            handValue += getCardValue(card);
            handValue = aceAs1or11(handValue);
         }
        return handValue;
    }



    private int aceAs1or11(int handValue){
        while (numberOfAces>0 && handValue> 21) {
            handValue -= 10;
        }
        return handValue;
    }

    private int getPlayerHandValue() {
        return this.playerHandValue;
    }



    private int getDealerHandValue() {
        return this.dealerHandValue;
    }

    private boolean didPlayerWin(int playerHandValue, int dealerHandValue){
        //compares the value to see which is greater
        return (playerHandValue >dealerHandValue);
    }

    private boolean didPlayerTie(int playerHandValue, int dealerHandValue){
        return (playerHandValue == dealerHandValue);
    }

    private boolean compare(){return false;}

    private boolean isNatural21(int handValue){
        //checks to see if starting hand is a Natural 21
        return (handValue == 21);
    }

    private void dealerNatural21(){
        // ends game for all who didn't have a natural 21
    }



    private boolean isBust(int handvalue){
        // checks if  handvalue is greater then 21
        return (handvalue > 21);
    }

    private boolean isSoft16(int dealerHandValue){
        // checks if dealer handvalue is greater then 17
        return false;
    }

    private void insurance(){
        // request bets for insurance
        // checks for dealers natural 21
    }

    private void playerTurn(){
        // runs loop for player's turn until bust or stay occurs
    }

    private void dealerTurn(){
        // runs loop for dealer's turn until bust or stay occurs. Soft16 conditions occurs
    }

    private boolean isLowCardCount(){
        //checks to see if shoe card count is 2.3 gone
        return false;
    }

    private void shuffleShoe(){
        // shuffles a new Shoe deck for blackjack.
    }
}