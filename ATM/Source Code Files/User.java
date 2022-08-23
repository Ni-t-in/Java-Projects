
/**
 * This is User calss which stores data of the user
 * @author : Nitin Mankar
 * @since  : 08/14/2022
 */

import java.util.ArrayList;
import java.security.MessageDigest;

public class User {

    // name of user
    private String firstName;
    private String lastName;

    // unique universal identifier
    private String uuid;

    // storing the hash of pin (using MD5 hashing)
    // it is secure to convert pin into hash incase database is leaked
    private byte pinHash[];

    // the list of accounts user have
    private ArrayList<Account> accounts;

    /**
     * explicit constructor
     * @param firstName : first name of user
     * @param lastName  : last name of user
     * @param pin       : pin of the user
     * @param theBank   : instance of class Bank
     */
    public User(String firstName, String lastName, String pin, Bank theBank) {

        // first name and last name
        this.firstName = firstName;
        this.lastName = lastName;

        // creating hash of pin entered by the user
        // try-catch block to catch error
        try {
            // digesting the pin provided by user into hash and storing it in pinHash
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (Exception e) {
            System.out.println("Error, caught exception : " + e.getMessage());
            System.exit(1);
        }

        // uuid generated by class Bank
        this.uuid = theBank.getNewUserUUID();       

        // initializing the accounts list
        this.accounts = new ArrayList<Account>();

        // display message for user creation
        System.out.printf("User added successfully...\nNew user       %s %s\nUser ID        %s\n",
                firstName, lastName, this.uuid);
    }
 
    /**
     * if the pin entered by user is valid or not
     * @param apin : pin of user
     * @return     : true - if pin equals else false
     */
    public boolean validatePin(String apin) {
        try {
            // if the pin entered by user is correct
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(apin.getBytes()), this.pinHash);
        } catch (Exception e) {
            System.out.println("Error , no such algorithm found");
            System.exit(1);
        }
        return false;
    }

    // to access uuid in other classes
    String getUUID() {
        return this.uuid;
    }

    /**
     * add account in list of accounts
     * @param newAccount : account to be added
     */
    public void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }

    // name of user
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    // obtain account summary
    public void printAccountsSummary() {
        System.out.printf("\n%s's all accounts summary\n\n", this.firstName);

        for (int a = 0; a < this.accounts.size(); a++) {
            String line = this.accounts.get(a).getSummaryLine();
            System.out.println(line);
        }
    }

    // number of accounts current user have
    public int numAccounts() {
        return this.accounts.size();
    }

    /**
     * balance of account
     * @param acc : account number
     * @return    : balance - if account exists else -1
     */
    public double getAcctBalance(String acc) {
        Account temp = findAccount(acc);
        if(temp != null){
            return temp.getBalance();
        }
        return -1d;
    }

    // 
    /**
     * adding transaction
     * @param acc    : account number
     * @param amount : money
     * @param memo   : memory of transaction
     */
    public void addAcctTransaction(String acc, double amount, String memo) {
        Account temp = findAccount(acc);
        temp.addTransaction(amount, memo);
    }

    /**
     * transaction history of account
     * @param acc : account number
     * @return    : true - if account exists else false
     */
    public boolean printAcctTransHistory(String acc) {
        Account temp = findAccount(acc);
        if(temp != null){
            temp.showTransactions();
            return true;
        }
        return false;
    }

    // 
    /**
     * find account in account list
     * @param acc : account number
     * @return    : account - if account exists else null
     */
    public Account findAccount(String acc){
        for(Account a : this.accounts){
            String dummy = a.getUUID();
            if(dummy.equals(acc)){
                return a;
            }
        }
        return null;
    }

    // first name of user
    public String getFirstName(){
        return firstName;
    }

    //last name of user
    public String getLastName(){
        return lastName;
    }
}