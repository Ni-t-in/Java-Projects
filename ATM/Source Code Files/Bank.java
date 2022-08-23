
/**
 * This is Bank calss which stores the data of users, accounts, generates uuids and create instance of user and account class
 * @author : Nitin Mankar
 * @since  : 08/14/2022
 */

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    // name of bank
    private String name;

    // the list of users associated with bank
    private ArrayList<User> users;

    // the list of accounts in the bank
    private ArrayList<Account> accounts;

    /**
     * explicit constructor
     * @param name : name of bank
     */ 
    public Bank(String name) {

        // name of bank
        this.name = name;

        //initialization of accounts list
        accounts = new ArrayList<Account>();

        //initialization of users list
        users = new ArrayList<User>();
    }
 
    /**
     * add account in accounts list
     * @param acc : account to be added
     */
    public void addAccount(Account acc) {
        this.accounts.add(acc);
    }

    // generate user uuid
    public String getNewUserUUID() {
        Random rand = new Random();
        boolean nonUnique;
        String uuid;
        int len = 6;

        // looping until we get unique uuid
        do {
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rand.nextInt(10)).toString();

            }
            nonUnique = false;

            // checking uuids from user list
            for (User u : this.users) {
                if (uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);

        return uuid;
    }

    // generate account uuid
    public String getNewAccountUUID() {
        Random rand = new Random();
        boolean nonUnique;
        String uuid;
        int len = 10;

        // looping until we get unique account uuid
        do {
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rand.nextInt(10)).toString();

            }
            nonUnique = false;

            // checking uuids from account list
            for (Account a : this.accounts) {
                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);

        return uuid;
    }
 
    /**
     * instantiating new user and account object
     * @param firstName : first name of user
     * @param lastName  : last name of user
     * @param pin       : pin of user
     * @param type      : type of account
     * @return          : created user object
     */
    public User addUser(String firstName, String lastName, String pin, String type) {

        // creating new user
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        // creating new account
        Account newAccount = new Account(type, newUser, this);
        this.accounts.add(newAccount);

        // add account in the list of user
        newUser.addAccount(newAccount);

        //add account in the bank's account list
        this.addAccount(newAccount);

        return newUser;
    }

    /**
     * checking if it is valid user
     * @param userID : user id
     * @param pin    : pin of user
     * @return       : user object which belongs to these parameters else null
     */
    public User userLogin(String userID, String pin) {
        for (User u : this.users) {
            if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin))
                return u;
        }
        return null;
    }

    /**
     * find if account exists
     * @param acc : account number
     * @return    : user object of this account else null
     */
    public User findAccount(String acc){
        for(Account a : this.accounts){
            String dummy = a.getUUID();
            if(dummy.equals(acc)){
                return a.getUser();
            }
        }
        return null;
    }

    // name of bank
    public String getName() {
        return this.name;
    }
}