
/**
 * This is Deck class which contains all card
 * @author : Nitin Mankar
 * @since  : 08/20/2022
 */

import java.util.Random;

public class Deck {

    // container to store cards
    private Card[] myCards;

    // number of cards
    private int numCards;

    // index of top card in deck
    private int deal = 0;

    /**
     * default constructor
     */
    public Deck(){
        this(1,false);
    }

    /**
     * explicit constructor
     * @param numDeck : number of decks in game
     * @param shuffle : to shuffle deck or not
     */
    public Deck(int numDeck, boolean shuffle){

        // number of cards, since each deck have 52 cards
        this.numCards = numDeck*52;

        // initializing array for cards
        this.myCards = new Card[this.numCards];

        // starting index of array
        int c = 0;
        for(int s = 0; s < 4; s++){
            for(int n = 1; n <= 13; n++){
                this.myCards[c] = new Card(Suit.values()[s], n);
                c++;
            }
        }

        //shuffle option
        if(shuffle){

            //shuffling
            this.shuffle();
        }
    }

    // shuffle cards
    public void shuffle(){

        // random object
        Random rand = new Random();

        // variable to store random number
        int j;
        
        for(int i = 0; i < this.myCards.length; i++){

            // will generate random number from 0 to number of cards - 1
            j = rand.nextInt(this.numCards);

            //swapping cards
            this.swap(this.myCards,i,j);
        }

    }

    // swap cards
    public void swap(Card[] arr, int i, int j){
        Card temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // dealing top cards
    public Card dealNextCard(){
        Card top = this.myCards[this.deal++];
        return top;
    }

    /**
     * printing whole deck
     * @param numToPrint : number of cards to print from deck
     */
    public void printDeck(int numToPrint){
        for(int i = 0; i < numToPrint; i++){
            System.out.println(this.myCards[i].toString());
        }
        System.out.println("\n" + (this.numCards - numToPrint) + " cards remaining....");
    }   
}
