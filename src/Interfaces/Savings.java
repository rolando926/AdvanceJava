package Interfaces;

/**
 * Created by RXC8414 on 2/7/2017.
 */
public class Savings implements IAccount{
    private double balance;
    private double minBalance;
    private String name;

    public Savings(String name, double amount){
        this.name = name;
        this.minBalance = 0;
        if (amount > 0){
            this.balance = amount;
        }
        else{
            // Display error message
            this.balance = 0;
        }
    }

    public Savings(String name, double amount, double minBalance){
        this.name = name;
        if (amount > 0){
            this.balance = amount;
        }
        else{
            // Display error message
            this.balance = 0;
        }
        if(minBalance > 0){
            this.minBalance = minBalance;
        }
        else{
            // Display error: reporting code omitted
            this.minBalance = 0;
        }
    }

    //Implement encapsulation for balance

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Implement encapsulation for minimum balance

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
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
        double tempBalance;
        if(amount > 0 && amount <= balance){
            tempBalance= balance - amount;
            if(tempBalance > minBalance){
                balance = tempBalance;
                return true;
            }
            else{
                System.out.println("Can't withdraw $"+amount+" Maximum withdraw amount is $"+(balance - minBalance));
                return false;
            }

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
