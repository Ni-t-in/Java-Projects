/**
 * This is Transaction calss which stores the transaction data
 * @author : Nitin Mankar
 * @since  : 08/14/2022
 */

import java.util.Date;

public class Transaction {

    // amount of transaction done by user
    private double amount ;

    // time and date of transaction
    private Date timestamp ;

    // memo for this transaction
    private String memo ;

    // account in which transaction is performed
    private Account inAccount ;
    
    /**
     * explicit constructor
     * @param amount    : transaction amount
     * @param inAccount : instance of class Acccount in which transaction is done
     */ 
    public Transaction(double amount , Account inAccount){

        // transaction amount
        this.amount = amount;

        // transaction account
        this.inAccount = inAccount ;

        // date and time of transaction
        this.timestamp = new Date();

        // empty memo
        this.memo = "";
    }

    /**
     * explicit constructor
     * @param amount    : transaction amount
     * @param memeo     : memory of transaction
     * @param inAccount : instance of class Acccount in which transaction is done
     */
    public Transaction(double amount, String memo, Account inAccount) {
		
        // constructor chaining
		this(amount, inAccount);

        // memo for transaction
		this.memo = memo;
	}
    
    // transaction amount
    public double getMoney(){
        return this.amount;
    }

    // transaction information
    public void transactionInfo(){
        System.out.println(this.amount + " " +this.inAccount.getUUID() +  " " + this.memo + " "+ this.timestamp);
    }
}