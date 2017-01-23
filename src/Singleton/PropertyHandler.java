package Singleton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by RXC8414 on 1/22/2017.
 */
public class PropertyHandler {
    private static final PropertyHandler instance = new PropertyHandler();
    private static final String CLASS_PROP = "C:\\AdvanceJava\\src\\InOut\\Resources\\class.properties";
    Properties prop = new Properties();

    private PropertyHandler(){
        readPropertiesFile();
    }

    public static PropertyHandler getInstance(){
        return instance;
    }

    private void readPropertiesFile(){
        try(FileReader file = new FileReader(CLASS_PROP);
            BufferedReader bReader = new BufferedReader(file);){
            prop.load(bReader);
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public String getValue(String propKey){
        return this.prop.getProperty(propKey);
    }
}
