package Interfaces;

/**
 * Created by RXC8414 on 2/7/2017.
 */
public interface IAccount {
    double getBalance();
    String getName();
    void setName(String name);
    void setBalance(double balance);
    boolean deposit(double amount);
    boolean withdrawl(double amount);
    //void display();
    public default void display(){
        System.out.println("****** Current Account Details ******");
        System.out.println("Name: "+this.getName());
        System.out.println("Current Balance: "+this.getBalance());
        System.out.println("******   End Account Details   ******");
    }
}
