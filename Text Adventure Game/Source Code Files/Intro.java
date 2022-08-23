
/**
 * This Intro class stores all scence
 * @author : Nitin Mankar
 * @since  : 08/03/2022
 */

public class Intro {
    // default constructor
    public Intro(){
    }

    // scence 1
    public void scence1(){
        System.out.println("You are summoned in another world standing in middle of palace");
        System.out.println("King : May i know the name of Hero");
    }

    /**
     * scence 2
     * @param name : name of player
     */
    public void scence2(String name){
        System.out.println("\nKing : " + name + " I summoned you here to defeat the Demon King, show me your Stats");
        System.out.println("Enchantress : " + name + " you can see your Stats by pressing '0'");
    }

    // scence 3
    public void scence3(){
        System.out.println("\nKing : Your Stats are pathetic, even lower than my foot soldiers\nKing : Guards throw him out of the palace");
        System.out.println("\n+-------------------------------------------------+");
        System.out.println("\nYou are thrown out of the town\nYou can go back to your world by getting killed");
    } 
}
