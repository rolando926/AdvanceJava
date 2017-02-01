package JDBC;

import java.io.*;
import java.util.Properties;

/**
 * Created by RXC8414 on 1/30/2017.
 */
public class DBProperties {
    private static DBProperties ourInstance = new DBProperties();

    Properties prop = new Properties();

    public static DBProperties getInstance() {
        return ourInstance;
    }

    private DBProperties() { readPropertiesFile();}

    private void readPropertiesFile(){
        try(InputStreamReader file = new InputStreamReader(getClass().getResourceAsStream ("/Resources/MySQL.properties"));
            BufferedReader in = new BufferedReader(file);){
            prop.load(in);
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
