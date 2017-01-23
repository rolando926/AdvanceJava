package Singleton;

/**
 * Created by RXC8414 on 1/22/2017.
 */
public class PropertiesMain {
    public static void main(String[] args) {
        System.out.println("URL = "+PropertyHandler.getInstance().getValue("url"));
        System.out.println("Browser = "+PropertyHandler.getInstance().getValue("browser"));
        System.out.println("Browser = "+PropertyHandler.getInstance().getValue("headerSearchBar"));
    }
}
