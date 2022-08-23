
/**
 * This Option class contains options for all scences 
 * @author : Nitin Mankar
 * @since  : 08/03/2022
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Option {

    // player data
    private GameData player;

    // option to select
    int option;
    Scanner scan = new Scanner(System.in);

    // default constructor
    public Option(){
    }

    /**
     * explicit constructor
     * @param player : player data
     */
    public Option(GameData player){

        // player data
        this.player = player;
    }

    // options
    public void option(){
        System.out.println("1. Health Points\n2. Magic Points\n3. Skills\n4. Weapon\n5. Companion\n6. Close");
    }

    // directions
    public void direction(){
        System.out.println("1. East\n2. West\n3. North\n4. South");
    }

    // companion died
    public void dead(){
        player.setCompanion("Fox(Dead)");
        player.setMP(0);
        player.setHP(0);
    }

    // check if player is alive
    public boolean check(){
        if(player.getMP() == 0 && player.getHP() == 0 ){
            return true;
        }
        return false;
    }

    // print player stats
    public void printStats(){
        System.out.println("Health Points : " + player.getHP() + " H.P");
        System.out.println("Magic Points : "+player.getMP() + " M.P");
        System.out.print("Skills : ");
        ArrayList<String> skills = player.getSkills();
        for(String x : skills){
            System.out.print(x + " | ");
        }
        System.out.println();
        System.out.println("Weapon : " + player.getWeapon());
        System.out.println("Companion : " + player.getCompanion());
    }

    // popup options
    public void popup(){
        do{
            option = scan.nextInt();
            switch(option){
                case 0:
                    option();
                    break;
                case 1:
                    System.out.println(player.getHP() + " H.P");
                    break;
                case 2:
                    System.out.println(player.getMP() + " M.P");
                    break;
                case 3:
                    ArrayList<String> skills = player.getSkills();
                    for(String x : skills){
                        System.out.print(x + " | ");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println(player.getWeapon());
                    break;
                case 5:
                    System.out.println(player.getCompanion());
                    break;
                case 6:
                    break;
                default:
                    System.out.println("You have chosen invalid option\nx_x DIE x_x");
                    System.exit(0);
            }
        }while(option != 6);
    }

    // options for scence 1
    public void scence1(){
        System.out.println("1. get killed!\n2. take revenge!\n3. continue!");
        do{
            option = scan.nextInt();
            switch(option){
                case 0:
                    option();
                    popup();
                    break;
                case 1:
                    System.out.println("You got bitten by a bee\nInstant death\nNew skill : Weakling");
                    player.getSkills().add("Weakling");
                    dead();
                    break;
                case 2:
                    System.out.println("The guards at the gate killed you\nNew skill : Brave Fool");
                    player.getSkills().add("Brave Fool");
                    dead();
                    break;
                case 3:
                    System.out.println("You got some injuries while struggle\nHealth points : -5 H.P");
                    player.setHP(player.getHP()-5);
                    scence2();
                    break;
                default:
                    System.out.println("Invalid option\nx_x DIE x_x");
                    System.exit(0);
            }
        }while(option < 1);
        if(check()){
            printStats();
            System.exit(0);
        }
    }

    // options for scence 2
    public void scence2(){
        direction();
        do{
            option = scan.nextInt();
            switch(option){
                case 0:
                    option();
                    popup();
                    break;
                case 1:
                    System.out.println("Found Wooden Club\nNew Weapon : Wooden Club");
                    player.setWeapon("Wooden Club");
                    break;
                case 2:
                    System.out.println("Found Witch attacked by Humans\n1. Help\n2. Leave");
                    option = scan.nextInt();
                    if(option == 1){
                        System.out.println("Witch : Thanks, Take reward");
                        System.out.println("New Skill : Saviour\nMagic Points : +10 M.P");
                        player.setMP(player.getMP()+10);
                        player.getSkills().add("Saviour");
                    }
                    else if(option == 2){
                        System.out.println("Got cursed\nHealth Points : -10 H.P\nMagic Points : -10 M.P");
                        System.out.println("Companion(dead) saved you from curse");
                        player.setHP(player.getHP()-10);
                        player.setMP(player.getMP()-10);
                        player.setCompanion("Fox(Dead)");
                    }
                    else{
                        System.out.println("Invalid option\nx_x DIE x_x");
                        System.exit(0);
                    }
                    break;
                case 3:
                    System.out.println("River ahead, Drank Water\nHealh Points : +5 H.P\nNew Skill : Survivor");
                    player.setHP(player.getHP()+5);
                    player.getSkills().add("Survivor");
                    break;
                case 4:
                    System.out.println("Encountered a cave");
                    System.out.println("1. Enter\n2. Avoid");
                    option = scan.nextInt();
                    if(option == 1){
                        System.out.println("Found Magic Potion\nMagic Points : +10 M.P\nNew Skill : Adventurer");
                        player.setMP(player.getMP()+10);
                        player.getSkills().add("Adventurer");
                    }
                    else if(option == 2){
                        System.out.println("Bitten by snake\nHealth Points : -20 H.P\nMagic Points : -20 M.P");
                        player.setHP(player.getHP()-20);
                        player.setMP(player.getMP()-20);
                    }
                    else{
                        System.out.println("Invalid option\nx_x DIE x_x");
                        System.exit(0);
                    }
                    break;
            }
        }while(option < 1);
        if(check()){
            printStats();
            System.exit(0);
        }else scence3();
    }

    // options for scence 3
    public void scence3(){
        direction();
        do{
            option = scan.nextInt();
            switch(option){
                case 0:
                    option();
                    popup();
                    break;
                case 1:
                    System.out.println("Found slimes!");
                    System.out.println("1. Kill 5 slimes\n2. Kill'em all");
                    option = scan.nextInt();
                    if(player.getWeapon().equals("Wooden Club")){
                        if(option == 1){
                            System.out.println("Magic Points : +5 M.P");
                            player.setMP(player.getMP()+5);
                        }
                        else if(option == 2){
                            System.out.println("Health Points : -10 H.P\nMagic Points : +10 M.P");
                            player.setHP(player.getHP()-10);
                            player.setMP(player.getMP()+10);
                        }
                        else{
                            System.out.println("Invalid option\nx_x DIE x_x");
                            System.exit(0);
                        }
                    }
                    else{
                        if(option == 1 || option == 2){
                            System.out.println("Killed by slimes");
                            dead();
                        }
                        else{
                            System.out.println("Invalid option\nx_x DIE x_x");
                            System.exit(0);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Found Town attacked by Bandits\n1. Help\n2. Leave");
                    option = scan.nextInt();
                    if(option == 1){
                        System.out.println("Mayor : Thanks, Take this reward");
                        System.out.println("New Skill : Protector\nNew Weapon : Sword\nMagic Points : +10 M.P");
                        player.setMP(player.getMP()+10);
                        player.getSkills().add("Protector");
                        player.setWeapon("Sword");
                    }
                    else if(option == 2){
                        System.out.println("Bandits noticed you\nGot killed");
                        dead();
                    }
                    else{
                        System.out.println("Invalid option\nx_x DIE x_x");
                        System.exit(0);
                    }
                    break;
                case 3:
                    System.out.println("Found Orchard\nApple tastes Sweet\nHealh Points : +5 H.P\nNew Skill : Fruitarian");
                    player.setHP(player.getHP()+5);
                    player.getSkills().add("Fruitarian");
                    break;
                case 4:
                    System.out.println("Encountered a Row house, its Night");
                    System.out.println("1. Rest\n2. Ignore");
                    option = scan.nextInt();
                    if(option == 1){
                        System.out.println("its Morning, Feeling refreshed\nHealth Points : +5 H.P\nNew Skill : Health Concious");
                        player.setHP(player.getHP()+5);
                        player.getSkills().add("Health Concious");
                    }
                    else if(option == 2){
                        System.out.println("Feeling tired\nHealth Points : -10 H.P\nMagic Points : -10 M.P");
                        player.setHP(player.getHP()-10);
                        player.setMP(player.getMP()-10);
                    }
                    else{
                        System.out.println("Invalid option\nx_x DIE x_x");
                        System.exit(0);
                    }
                    break;
            }
        }while(option < 1);
        if(check()){
            printStats();
            System.exit(0);
        }else scence4();
    }

    // options for scence 4
    public void scence4(){
        direction();
        do{
            option = scan.nextInt();
            switch(option){
                case 0:
                    option();
                    popup();
                    break;
                case 1:
                    System.out.println("Found Devil!, Give me 10 H.P get 5 M.P");
                    System.out.println("1. Accept\n2. Decline");
                    option = scan.nextInt();
                    if(option == 1){
                        System.out.println("Health Points : -10\nMagic Points : +5 M.P\nNew Skill : Life Trader");
                        player.setMP(player.getMP()+5);
                        player.setHP(player.getHP()-10);
                        player.getSkills().add("Life Trader");
                    }
                    else if(option == 2){
                        System.out.println("Devil : Talking toll\nHealth Points : -5 H.P");
                        player.setHP(player.getHP()-5);
                    }
                    else{
                        System.out.println("Invalid option\nx_x DIE x_x");
                        System.exit(0);
                    }
                    break;
                case 2:
                    System.out.println("Encountered Lion\n1. Fight\n2. Escape");
                    option = scan.nextInt();
                    if(player.getWeapon().equals("Sword")){
                        if(option == 1){
                            System.out.println("Health Points : -30 H.P\nMagic Points : +10 M.P\nNew Skill : MadMan");
                            player.setMP(player.getMP()+10);
                            player.setHP(player.getHP()-30);
                            player.getSkills().add("MadMan");
                        }
                        else if(option == 2){
                            System.out.println("Lion chased you\nDead\nNew Skill : Coward");
                            player.getSkills().add("Coward");
                            dead();
                        }
                        else{
                            System.out.println("Invalid option\nx_x DIE x_x");
                            System.exit(0);
                        }
                    }
                    else{
                        if(option == 1){
                            System.out.println("Killed by Lion\nNew Skill : Brave");
                            player.getSkills().add("Brave");
                            dead();
                        }
                        else if(option ==2){
                            System.out.println("Lion chased you\nDead\nNew Skill : Coward");
                            player.getSkills().add("Coward");
                            dead();
                        }
                        else{
                            System.out.println("Invalid option\nx_x DIE x_x");
                            System.exit(0);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Found Old Lady donating Food\n1.Take\n2.Avoid");
                    option = scan.nextInt();
                    if(option == 1){
                        System.out.println("Poisoned(She was thief)\nNew Skill : Food Greed | Mugged");
                        player.getSkills().add("Food Greed");
                        player.getSkills().add("Mugged");
                        dead();
                    }
                    else if(option ==2){
                        System.out.println("You avoided Death\nNew Skill : Cautious\nMagic Points : +5 M.P");
                        player.setMP(player.getMP()+5);
                        player.getSkills().add("Cautious");
                    }
                    else{
                        System.out.println("Invalid option\nx_x DIE x_x");
                        System.exit(0);
                    }
                    break;
                case 4:
                    System.out.println("Encountered rice field\nHealth Points : +5 H.P\nNew Skill : Cook");
                    player.setHP(player.getHP()+5);
                    player.getSkills().add("Cook");
                    break;
            }
        }while(option < 1);
        if(check()){
            printStats();
            System.exit(0);
        }else scence5();
    }

    // options for scence 5
    public void scence5(){
        direction();
        do{
            option = scan.nextInt();
            switch(option){
                case 0:
                    option();
                    popup();
                    break;
                case 1:
                    System.out.println("Found Sage!");
                    System.out.println("1. Get Trained\n2. Fight");
                    option = scan.nextInt();
                    if(option == 1){
                        System.out.println("Magic Points : +10 M.P\nNew Skill : Desciple");
                        player.setMP(player.getMP()+10);
                        player.setHP(player.getHP()-10);
                        player.getSkills().add("Desciple");
                    }
                    else if(option == 2 && player.getMP() > 40 && player.getHP() > 50){
                        System.out.println("Magic Points : +20 M.P\nNew Skill : Prodigy");
                        player.setMP(player.getMP()+20);
                        player.getSkills().add("Prodigy");
                    }
                    else if(option == 2){
                        System.out.println("Health Points : -30 H.P\nMagic Points : -20 M.P\nNew Skill : Ignorant");
                        player.setMP(player.getMP()-20);
                        player.setHP(player.getHP()-30);
                        player.getSkills().add("Ignorant");
                    }
                    else{
                        System.out.println("Invalid option\nx_x DIE x_x");
                        System.exit(0);
                    }
                    break;
                case 2:
                    System.out.println("Encountered Goblin\n1. Fight\n2. Escape");
                    option = scan.nextInt();
                    if(player.getWeapon().equals("Sword")){
                        if(option == 1){
                            System.out.println("Health Points : -10 H.P\nMagic Points : +10 M.P\nNew Skill : Goblin Slayer");
                            player.setMP(player.getMP()+10);
                            player.setHP(player.getHP()-10);
                            player.getSkills().add("Goblin Slayer");
                        }
                        else if(option == 2){
                            System.out.println("Gang of goblin surrounded you\nDead\nNew Skill : Goblin Food");
                            player.getSkills().add("Goblin Food");
                            dead();
                        }
                        else{
                            System.out.println("Invalid option\nx_x DIE x_x");
                            System.exit(0);
                        }
                    }
                    else{
                        if(option == 1 && player.getMP() >= 40 && player.getHP() >= 40){
                            System.out.println("Health Points : -20 H.P\nMagic Points : +20 M.P\nNew Skill : Goblin Slayer");
                            player.setMP(player.getMP()+20);
                            player.setHP(player.getHP()-20);
                            player.getSkills().add("Goblin Slayer");
                        }
                        else if(option ==2){
                            System.out.println("Gang of goblin surrounded you\nDead\nNew Skill : Goblin Food");
                            player.getSkills().add("Goblin Food");
                            dead();
                        }
                        else{
                            System.out.println("Invalid option\nx_x DIE x_x");
                            System.exit(0);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Found hidden temple\nMagic Points : +10 M.P\nNew Skill : Saint");
                    player.setMP(player.getMP()+10);
                    player.getSkills().add("Saint");
                    break;
                case 4:
                    System.out.println("Found Sword, stuck in stone");
                    if(player.getHP() >= 40){
                        System.out.println("New Weapon : Excalibur\nMagic Points : +20 M.P\nNew Skill : Newborn Hero");
                        player.setMP(player.getMP()+20);
                        player.getSkills().add("Newborn Hero");
                    }
                    else{
                        System.out.println("You are not capable");
                    }
                    break;
            }
        }while(option < 1);
        if(check()){
            printStats();
            System.exit(0);
        }else scence6();
    }

    // options for scence 6
    public void scence6(){
        System.out.println("The Demon King is killing King who summoned you\n1. Save\n2. Let him killed");
        option = scan.nextInt();
        switch(option){
            case 1:
                System.out.println("You saved th King\nHealh Points : -10 H.P\nMagic Points : +10 M.P\nNew Skill : Magnanimous");
                player.setHP(player.getHP()-10);
                player.setMP(player.getMP()+10);
                player.getSkills().add("Magnanimous");
                break;
            case 2:
                System.out.println("New Skill : Cold Hearted\nMagic Points : +10 M.P");
                player.setMP(player.getMP()+10);
                player.getSkills().add("Cold Hearted");
                break;
            default:
                System.out.println("Invalid option\nx_x DIE x_x");
                System.exit(0);
        }
        if(check()){
            printStats();
            System.exit(0);
        }else finalScence();
    }

    // options for final scence
    public void finalScence(){
        System.out.println("This is final stage press '0' to check your stats");
        option = scan.nextInt();
        if(option == 0){
            option();
            popup();
        }
        System.out.println("You reached the Demon King");
        System.out.println("Stats required to beat Demon King");
        System.out.println("Health Points : 75 H.P\nMagic Points : 65 M.P");
        System.out.println("Fight Began\nX\n         xxXXXx\n*..*    .*");
        if(player.getMP() >= 65 && player.getHP() >= 75){
            System.out.println("Demon King : How can this happen\nDemon King : I put curse on you when you were summoned");
            System.out.println("Demon King : Aaaaa... I am dead");
            System.out.println("You defeted the Demon King");
            System.out.println("New Skill : Demon Slayer");
        }
        else{
            System.out.println("Demon King : Nobody in this world can defeat me\nHuh some kind of hero you were");
            System.out.println("New Skill : Failed Hero");
            dead();
        }
        printStats();
        System.exit(0);
    }
}
