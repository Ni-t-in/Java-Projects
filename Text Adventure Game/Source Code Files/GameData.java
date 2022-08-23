
/**
 * This GameData class stores all stats of player
 * @author : Nitin Mankar
 * @since  : 08/03/2022
 */

import java.util.ArrayList;

public class GameData {

    // name of player
    private String name;

    // health points
    private int hp;

    // magic points
    private int mp;

    // list of skills
    private ArrayList<String> skills = new ArrayList<>();

    // weapon of player
    private String weapon;

    // companion of player
    private String companion;

    /**
     * explicit constructor
     * @param name : name of player
     */
    public GameData(String name){
        if(name.equals("Nitin")){
            this.name = name;
            this.hp = 100;
            this.mp = 100;
            this.skills.add("GodLike");
            this.skills.add("OverPowered");
            this.skills.add("Almight");
            this.weapon = "MurakuMogiri";
            this.companion = "Dragon";
        }
        else{
            this.name = name;
            this.hp = 80;
            this.mp = 30;
            this.skills.add("Novice");
            this.weapon = "None";
            this.companion = "Fox";
        }
    }

    /**
     * access companion in other classes
     * @param str : companion
     */
    public void setCompanion(String str){
        this.companion = str;
    }

    /**
     * set magic points from other classes
     * @param points
     */
    public void setMP(int points){
        this.mp = points;
    }

    /**
     * set health points from other classes
     * @param points
     */
    public void setHP(int points){
        this.hp = points;
    }

    /**
     * access magic point from other classes
     * @return : magic points
     */
    public int getMP(){
        return this.mp;
    }

    /**
     * access health point from other classes
     * @return : health points
     */
    public int getHP(){
        return this.hp;
    }

    /**
     * access skills list from other classes
     * @return : skills list
     */
    public ArrayList<String> getSkills(){
        return this.skills;
    }

    /**
     * access weapon from other classes
     * @return : weapon
     */
    public String getWeapon(){
        return this.weapon;
    }

    /**
     * access companion from other classes
     * @return : companion
     */
    public String getCompanion(){
        return this.companion;
    }

    /**
     * set weapon from other classes
     * @param : weapon
     */
    public void setWeapon(String wep){
        this.weapon = wep;
    }

    // access name from other classes
    public String getName(){
        return this.name;
    }
    
    // scence 1
    public void scence1(){
    }
}
