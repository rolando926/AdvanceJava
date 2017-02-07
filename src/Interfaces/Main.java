package Interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;
abstract
/**
 * Created by RXC8414 on 2/7/2017.
 */
public class Main {

    public static void main(String[] args) {
        // Create an account
        Savings mySavings = new Savings("Rolando Colon",100.00,50.00);

        //Make a deposit
        if(!mySavings.deposit(scan("DEPOSIT"))){
            System.out.println("Error: Incorrect deposit amount.");
        }

        //Make a withdraw
        if(mySavings.withdrawl(scan("WITHDRAW"))){
            System.out.println("Error: Incorrect withdraw amount.");
        }
        mySavings.display();

        //mySavings.display("Today");
    }

    public static double scan(String type){
        Scanner scanner = new Scanner(System.in);
        try {

            switch (type.toUpperCase()) {
                case "DEPOSIT":
                    System.out.println("Please enter the amount to deposit in XX.xx format: ");
                    break;
                case "WITHDRAW":
                    System.out.println("Please enter the amount to withdraw in XX.xx format: ");
                    break;
            }
            return Double.valueOf(scanner.next("^[0-9]+(\\.[0-9][0-9])"));
        }catch(InputMismatchException ime){
            System.out.println("Incorrect amoount entered! Must have dollars and cents (2 decimal points).");
        }
        return -1;
    }
}
