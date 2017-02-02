package Hash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import JDBC.dbUtils;

/**
 * Created by RXC8414 on 2/2/2017.
 */
public class HashUtils {
    //Step #1
    HashMap map = new HashMap();
    Hashtable table = new Hashtable();
    String strQuery = "select * from tblemployee";
    public String URL = "jdbc:mysql://localhost:3306/training?useSSL=false";
    public String USER = "root";
    public String PASSWORD = "Or01ana01";

    public void assignHashMapValues(){
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strQuery);
        ) {
            while(rs.next()) {
                //Step #2
                map.put(rs.getInt(1),rs.getString(2)+","+rs.getString(3));
            }

            // Step #3 and #4
            Set set = map.entrySet();
            Iterator i = set.iterator();

            // Step #5
            while(i.hasNext()){
                Map.Entry me = (Map.Entry)i.next();
                System.out.println(me.getKey()+":"+me.getValue());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
