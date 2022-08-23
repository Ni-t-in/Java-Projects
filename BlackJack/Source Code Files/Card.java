
/**
 * This is Card class which stores the suit an number of card
 * @author : Nitin Mankar
 * @since  : 08/20/2022
 */

public class Card {

    // suit of current card
    private Suit mySuit;

    // number of current card
    // ace = 1, jack = 11, queen = 12, king = 13 and rest based on there number 
    private int myNumber;

    /**
     * explicit constructor
     * @param aSuit : suit of current card
     * @param num   : number of current card
     */
    public Card(Suit aSuit, int num){

        // suit of card
        this.mySuit = aSuit;

        //number of card
        this.myNumber = num;
    }

    // obtain number of card
    public int getNumber(){
        return this.myNumber;
    }

    // creating card using suit and number
    public String toString(){
        String[] card = {"Ace  ","Two  ","Three","Four ","Five ","Six  ","Seven","Eight","Nine ","Ten  ","Jack ","Queen","King "};
        int num = this.myNumber - 1;
        String numStr = card[num];
        return numStr + " of " + mySuit.toString();
    }
}