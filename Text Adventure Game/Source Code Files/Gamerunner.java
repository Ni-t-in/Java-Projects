
/**
 * This Gamerunner class contains main class of this text based adventure game 
 * @author : Nitin Mankar
 * @since  : 08/03/2022
 */

import java.util.Scanner;

public class Gamerunner {
    public static String input(){
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        return name;
    }
    public static void main(String[] args) throws Exception {
        Intro dialog = new Intro();
        dialog.scence1();
        String playerName = input();
        GameData player = new GameData(playerName);
        dialog.scence2(player.getName());
        Option option = new Option(player);
        option.popup();
        dialog.scence3();
        option.scence1();
        option.scence2();
    }
}
