package Interfaces;

/**
 * Created by RXC8414 on 2/7/2017.
 */
public class Checking implements IAccount{
    private double balance;
    private String name;

    //Constructor
    public Checking(String name, double amount){
        this.name = name;
        if(amount > 0){
            this.balance = amount;
        }
        else{
            // Display error message
            this.balance = 0;
        }
    }

    //Implement encapsulation for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Implement encapsulation for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean deposit(double amount){
        if(amount > 0){
            balance+=amount;
            return true;
        }
        else if(amount < 0){
            // Display error message
            return false;
        }
        else{
            // Display error message
            return false;
        }
    }

    public boolean withdrawl(double amount){
        if(amount > 0 && amount <= balance){
            balance-=amount;
            return true;
        }
        else if(amount > balance){
            // Display error message
            return false;
        }
        else{
            // Display error message
            return false;
        }
    }

}
