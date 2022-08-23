
/**
 * This is ATM class which contains main method of whole project
 * @author : Nitin Mankar
 * @since  : 08/14/2022
 */

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // creation of instance of class Bank
        System.out.println("Enter name of Bank");
        String bankName = sc.nextLine();
        Bank theBank = new Bank(bankName);

        // the number of accounts you want to create
        System.out.println("Enter the number of accounts to be made");
        int num = sc.nextInt();
        for(int i = 0; i < num; i++){
            sc.nextLine();
            createCustomers(theBank, sc);
        }

        // empty User variable 
        User curUser;
        while(true){

            // user verification
            curUser = ATM.authenticUser(theBank ,sc);

            // print menu
            ATM.printUserMenu(curUser, sc, theBank);
        }
    }

    // create account
    public static void createCustomers(Bank theBank, Scanner sc){
        System.out.println("Enter first name of user");
        String firstName = sc.nextLine();
        System.out.println("Enter last name of user");
        String lastName = sc.nextLine();
        System.out.println("Create new PIN for user");
        String pin = sc.nextLine();
        
        int option;
        do{
            System.out.println("Select type of account\n1. Savings\n2. Current\n3. Salary");
            option = sc.nextInt();
            if(option < 1 || option > 3){
                System.out.println("Invalid input try again");
            } 
        }while(option < 1 || option > 3);
        String type = "Savings";
        switch (option){
            case 1 :
                break;
            case 2 :
                type = "Current";
                break;
            case 3 :
                type = "Salary";
                break;
        }
        sc.nextLine();
        System.out.println();
        User newUser = theBank.addUser(firstName,lastName,pin,type);
    }

    // user verification
    public static User authenticUser(Bank theBank, Scanner sc){
        String userId;
        String pin;
        User authUser;

        do{
            sc.nextLine();
            System.out.println("\nWelcome to " + theBank.getName());
            System.out.println("Enter User ID");
            userId = sc.nextLine();
            System.out.println("Enter PIN");
            pin = sc.nextLine();
            authUser = theBank.userLogin(userId, pin);
            if(authUser == null){
                System.out.println("Error : Id Pin Mismatch\nPlease try again");
            }
        }while(authUser == null);
        return authUser;
    }

    // print Menu
    public static void printUserMenu(User theUser, Scanner sc,Bank theBank){
        int option;
        do{
            System.out.println("\nWelcome Mr. " + theUser.getName());
            theUser.printAccountsSummary();

            System.out.println("\n1. Transaction History\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Create new account\n6. Quit");
            System.out.println("Select option");
            option = sc.nextInt();
            System.out.println();
            if(option < 1 || option > 5){
                System.out.println("Invalid selection try again");
            }
        }while(option < 1 || option > 5);
        sc.nextLine();
        switch (option){
            case 1:
                ATM.transactionHistory(theUser, sc);
                break;
            case 2:
                ATM.withdraw(theUser, sc);
                break;
            case 3:
                ATM.deposit(theUser, sc);
                break;
            case 4:
                ATM.transfer(theBank, theUser, sc);
                break;
            case 5:
                ATM.createNewAccount(theBank, theUser, sc);
                break;
            default:
                System.exit(0);
        }
    }

    // print transaction history
    public static void transactionHistory(User theUser, Scanner sc){
        String theAcc;
        boolean notFound = true;
        do{
            System.out.println("Enter account number");
            theAcc = sc.nextLine();
            if(theUser.printAcctTransHistory(theAcc)){
                notFound = false;
            }
            else{
                System.out.println("Invalid account number please try again");
            }
        }while(notFound);
    }

    // withdraw funds
    public static void withdraw(User theUser, Scanner sc){
        String fromAcc;
        double amount;
        double actBal;
        String memo;
        int tries = 0;
        boolean notFound = true;
        do{
            System.out.println("Enter account number");
            fromAcc = sc.nextLine();
            actBal = theUser.getAcctBalance(fromAcc);
            if(actBal != -1){
                notFound = false;
            }
            else{
                System.out.println("Account not found please try again");
            }
        }while(notFound);
        System.out.printf("Current balance Rs %.02f\n\n",actBal);
        do{
            System.out.println("Enter withdraw amount");
            amount = sc.nextDouble();
            if(amount < 100 && actBal > 100){
                tries++;
                System.err.println("Minimum withdrwal limit : Rs 100");
            }
            else if(amount > actBal){
                tries++;
                System.err.println("Insufficient funds");
            }
            if(tries == 3){
                return;
            }
            System.out.println("Remaining Trials : " + (3 - tries));
        }while(amount < 100 || amount > actBal);
        sc.nextLine();
        System.out.println("Enter memo");
        memo = sc.nextLine();
        theUser.addAcctTransaction(fromAcc, -amount, memo);
    }

    //deposit funds
    public static void deposit(User theUser, Scanner sc){
        String toAcc;
        double amount;
        double actBal;
        String memo;
        int tries = 0;
        boolean notFound = true;
        do{
            System.out.println("Enter account number");
            toAcc = sc.nextLine();
            actBal = theUser.getAcctBalance(toAcc);
            if(actBal != -1){
                notFound = false;
            }
            else{
                System.out.println("Account not found please try again");
            }
        }while(notFound);
        System.out.printf("Current balance Rs %.02f\n\n",actBal);
        do{
            System.out.println("Enter deposit amount");
            amount = sc.nextDouble();
            if(amount < 100){
                tries++;
                System.out.println("Minimum deposit limit : Rs 100");
            }
            if(tries == 3){
                return;
            }
            System.out.println("Remaining Trials : " + (3 - tries));
        }while(amount < 100);
        sc.nextLine();
        System.out.println("Enter memo");
        memo = sc.nextLine();
        theUser.addAcctTransaction(toAcc, amount, memo);  
    }
    
    // transfer funds from one account to another
    public static void transfer(Bank theBank, User theUser, Scanner sc){
        String fromAcc;
        String toAcc;
        double amount;
        double actBal;
        User toAccUser;
        int tries = 0;
        boolean notFound = true;
        do{
            System.out.println("Enter Transferer account number");
            fromAcc = sc.nextLine();
            actBal = theUser.getAcctBalance(fromAcc);
            if(actBal != -1){
                notFound = false;
            }
            else{
                System.out.println("Account not found please try again");
            }
        }while(notFound);
        System.out.printf("Current balance Rs %.02f\n",actBal);
        notFound = true;
        do{
            System.out.println("Enter Reciever account number");
            toAcc = sc.nextLine();
            toAccUser = theBank.findAccount(toAcc);
            if(toAccUser != null){
                notFound = false;
            }
            else{
                System.out.println("Account not found please try again");
            }
        }while(notFound);
        sc.nextLine();
        do{
            System.out.println("Enter transfering amount");
            amount = sc.nextDouble();
            if(amount < 100){
                tries++;
                System.out.println("Minimum transferable limit : Rs 100");
            }
            else if(amount > actBal){
                tries++;
                System.out.println("Insufficient funds");
            }
            if(tries == 3){
                return;
            }
            System.out.println("Remaining Trials : " + (3 - tries));
        }while(amount < 100 || amount > actBal);
        sc.nextLine();
        theUser.addAcctTransaction(fromAcc, -amount, String.format("Transfer to account %s", toAcc));
        toAccUser.addAcctTransaction(toAcc, amount, String.format("Recieved from account %s", fromAcc));
    }

    // create new account of existing user
    public static void createNewAccount(Bank theBank,User theUser, Scanner sc){
        System.out.println("Create new PIN for user");
        String pin = sc.nextLine();
        
        int option;
        do{
            System.out.println("Select type of account\n1. Savings\n2. Current\n3. Salary");
            option = sc.nextInt();
            if(option < 1 || option > 3){
                System.out.println("Invalid input try again");
            } 
        }while(option < 1 || option > 3);
        String type = "Savings";
        switch (option){
            case 1 :
                break;
            case 2 :
                type = "Current";
                break;
            case 3 :
                type = "Salary";
                break;
        }

        Account newAcc = new Account(type, theUser, theBank);
        theUser.addAccount(newAcc);
        theBank.addAccount(newAcc);
        sc.nextLine();
    }
}
