package Singleton;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by RXC8414 on 1/22/2017.
 */
public class PropertyHandler {
    private static final PropertyHandler instance = new PropertyHandler();
    Properties prop = new Properties();

    private PropertyHandler(){
        readPropertiesFile();
    }

    public static PropertyHandler getInstance(){
        return instance;
    }

    private void readPropertiesFile(){
        try(FileReader file = new FileReader(new File("").getAbsolutePath()+"\\src\\Resources\\class.properties");
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
