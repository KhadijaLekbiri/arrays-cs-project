package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    int transactionId = 0;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if ( amount >= 0){
            currentBalance += amount;
            transactions[this.transactionId] = amount;
            this.transactionId++;
            System.out.println("Name : "+name+"\nDisposited amount : "+amount+"\nNew balance : "+ currentBalance);
        }
        else {
            System.out.println("Unsuccessful deposit");
        }
    }

    public void withdraw(double amount){
        if ( 0 <= amount && amount <= currentBalance){
            currentBalance -= amount;
            transactions[this.transactionId] = -amount;
            this.transactionId++;
            System.out.println("Name : "+name+"\nWithdrawn amount : "+amount+"\nNew balance : "+ currentBalance);
        }
        else {
            System.out.println("Unsuccessful withdrawal");
        }
    }

    public void displayTransactions(){
        for (int i = 0; i < this.transactionId; i++){
            System.out.println(transactions[i]);
        }
    }

    public void displayBalance(){
        System.out.println("The current balance is: "+currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
