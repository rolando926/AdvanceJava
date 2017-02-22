package BuiderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RXC8414 on 2/8/2017.
 */
public class Main {
    public static void main(String[] args) {
        BuiderPattern bp = new BuiderPattern.BuiderPatternBuilder()
                .setGivenName("Rolando")
                .setSurName("Colon")
                .setAge(43)
                .setGender("M")
                .setEmail("rolando.colon926@gmail.com")
                .setAddress("Some Address")
                .setCity("Cumming")
                .setState("GA")
                .setPhone("770-878-7160")
                .createBuiderPattern();

        ClassA c = new ClassA.ClassABuilder()
                .setBlnTrue(true)
                .setString("Some value")
                .createClassA();


        // Print all values from class
        System.out.print(bp);
    }
}
