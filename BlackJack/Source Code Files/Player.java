
/**
 * This is Player class which stores the information and hand of player
 * @author : Nitin Mankar
 * @since  : 08/20/2022
 */

import java.util.Arrays;

public class Player {

    // name of player
    private String name;

    // cards in hand of player
    private Card[] hand = new Card[10];

    // number of cards in player's hand
    private int numCards;

    /**
     * explicit constructor
     * @param aName : name of player
     */
    public Player(String aName){

        // name of player
        this.name = aName;

        // clearing the hand of player from previous game if has any cards
        this.emptyHands();
    }

    // clearing hand of player
    public void emptyHands(){

        // emptying array
        Arrays.fill(hand,null);

        //setting number of cards to 0
        this.numCards = 0;
    }

    /**
     * adding card in player's hand (max limit : 10 cards)
     * @param aCard : card from the deck
     * @return      : false - no cards can be added, true - cards can be added
     */
    public boolean addCard(Card aCard){

        // if there are already 10 cards
        if(this.numCards == 10){
            System.err.println(this.name + "'s hand already has 10 cards\nNo cards can be added furthur");
            return false;
        }
        // if cards are less than 10
        this.hand[this.numCards] = aCard;
        this.numCards++;

        //if sum is greater than 21 no furthur card can be added
        return (this.getHandSum() <= 21);
    }

    // sum of inhand cards
    public int getHandSum(){

        //intial sum
        int handSum = 0;

        //value of card
        int cardNum;

        // number of Aces
        int numAces = 0;

        for(int i = 0; i < this.numCards; i++){
            cardNum = this.hand[i].getNumber();

            // Ace
            if(cardNum == 1){
                numAces++;
                handSum += 11;
            }
            // Face cards
            else if(cardNum > 10){
                handSum += 10;
            }
            // Rest cards
            else{
                handSum += cardNum;
            }
        }

        // an Ace can be added as 1 or 11 depending on player
        // if sum became greater than 21 and if we have Ace use it as 1
        while(handSum > 21 && numAces > 0){
            handSum -= 10;
            numAces--;
        }

        return handSum;
    }

    /**
     * print all cards in hand
     * @param showFirstCard : option to show first card specially for dealer
     */
    public void printHand(boolean showFirstCard){
        System.out.println(this.name + "'s cards");
        for(int i = 0; i < this.numCards; i++){

            // to hide first card
            if(i == 0 && !showFirstCard){
                System.out.println("***** of ********");
            }
            else{
                System.out.println(this.hand[i].toString());
            }
        }
    }

    // player's name
    public String getName(){
        return this.name;
    }

}
