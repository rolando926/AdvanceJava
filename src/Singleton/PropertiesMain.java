package Singleton;

/**
 * Created by RXC8414 on 1/22/2017.
 */
public class PropertiesMain {
    public static void main(String[] args) {
        System.out.println("URL = "+PropertyHandler.getInstance().getValue("URL"));
        System.out.println("Browser = "+PropertyHandler.getInstance().getValue("browser"));
        System.out.println("headerSearchBar = "+PropertyHandler.getInstance().getValue("headerSearchBar"));
    }
}
