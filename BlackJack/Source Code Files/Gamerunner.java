
/**
 * This is Gamerunner class which has main method and all functions of playing
 * @author : Nitin Mankar
 * @since  : 08/20/2022
 */

import java.util.Scanner;

public class Gamerunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // creating players
        System.out.println("Enter player's name");
        String player = sc.next();
        Player me = new Player(player);
        Player dealer = new Player("Dealer");
        sc.nextLine();

        // creating deck
        System.out.println("\nEnter number of decks");
        int deck = sc.nextInt();
        Deck theDeck = new Deck(deck, true);
        
        // dealing first two cards
        for(int i = 0; i < 2; i++){
            me.addCard(theDeck.dealNextCard());
            dealer.addCard(theDeck.dealNextCard());  
        }

        // printing hands of both player
        System.out.println("Cards are dealt\n");
        me.printHand(true);
        System.out.println();
        dealer.printHand(false);
        System.out.println();

        // variable to decide more card can be dealt by
        // meDone - player, dealerDone - dealer
        boolean meDone = false;
        boolean dealerDone = false;

        //variable for Hit or Stay
        String ans;

        while(!meDone || !dealerDone){
            if(!meDone){
                System.out.println("Hit(H) or Stay(S)\nEnter \"H\" or \"S\"");
                ans = sc.next();
                sc.nextLine();
                System.out.println();
                if(ans.equalsIgnoreCase("H")){
                    meDone = !me.addCard(theDeck.dealNextCard());
                    me.printHand(true);
                    System.out.println();
                }
                else{
                    meDone = true;
                }
            }

            if(!dealerDone){
                if(dealer.getHandSum() < 17){
                    System.out.println("Dealer Hits");
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    dealer.printHand(false);
                    System.out.println();
                }
                else{
                    System.out.println("Dealer Stays\n");
                    dealer.printHand(false);
                    dealerDone = true;
                }
            }
            System.out.println();
        }
        
        // final showdown of hands
        me.printHand(true);
        System.out.println();
        dealer.printHand(true);
        System.out.println();

        // final sum of hands for both players 
        int meSum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        // result
        if(meSum > dealerSum && meSum <= 21 || dealerSum > 21){
            System.out.println(me.getName() + " Wins");
            System.out.println();
        }
        else{
            System.out.println("Dealer Wins");
            System.out.println();
        }
    }
}
