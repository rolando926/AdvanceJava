package JDBC;

import Singleton.PropertyHandler;

import java.sql.*;

/**
 * Created by RXC8414 on 1/29/2017.
 */
public class dbUtils {
    //public static final String URL = "jdbc:mysql://localhost:3306/training?useSSL=false";
    public String URL;
    public String USER;
    public String PASSWORD;

    public dbUtils(){
        this.URL = DBProperties.getInstance().getValue("URL");
        this.USER = DBProperties.getInstance().getValue("USER");
        this.PASSWORD = DBProperties.getInstance().getValue("PASSWORD");
    }

    //Create getDataSet
    public void getDataSet(String strQuery){
        int type;
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strQuery);
            ){
            if(rs != null) {
                while (rs.next()) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    for(int i = 1; i <= rsmd.getColumnCount(); i++){
                        if(i > 1){
                            System.out.print(",");
                        }
                        type = rsmd.getColumnType(i);
                        switch(type){
                            case Types.INTEGER:
                                System.out.print(rs.getInt(i));
                                break;
                            case Types.DECIMAL:
                                System.out.print(rs.getDouble(i));
                                break;
                            case Types.VARCHAR:
                                System.out.print(rs.getString(i));
                                break;
                            default:
                                System.out.print("Unknown Data Type");
                                break;
                        }
                    }
                    System.out.println();
                }
            }
        }catch(SQLException sql){
            sql.printStackTrace();
        }
    }

    //Create doUpdateInsert
    public void doUpdateInsert(String strQuery){
        int intRecords;
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmt = conn.createStatement();){
            intRecords = stmt.executeUpdate(strQuery);
            if(intRecords > 0){
                if(strQuery.toUpperCase().contains("UPDATE") ||
                        strQuery.toUpperCase().contains("INSERT")) {
                    System.out.println(intRecords + " record(s) were added into " + getDBTableFromQuery(strQuery));
                }else{
                    System.out.println(intRecords + " record(s) were deleted from " + getDBTableFromQuery(strQuery));
                }
            }
        }catch(SQLException sql){
            sql.printStackTrace();
        }
    }

    public String getDBTableFromQuery(String strQuery){
        String DBTable = null;
        if(strQuery.toUpperCase().contains("UPDATE")){
            DBTable = strQuery.substring(7, strQuery.toUpperCase().indexOf(" SET"));
        }else if(strQuery.toUpperCase().contains("INSERT")){
            DBTable = strQuery.substring(12, strQuery.toUpperCase().indexOf(" VALUES"));
        }
        return DBTable;
    }

    //Create doExecute
    public void doExecute(){

    }

    //Create getRecordCount
    public int getRecordCount(String strQuery){
        int count = 0;
        //Format strQuery to correct format
        strQuery = strQuery.toUpperCase();
        strQuery = "SELECT COUNT(1) "+ strQuery.substring(strQuery.indexOf("FROM"));
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strQuery);){
            //Get data value
            while(rs.next()){
                count = rs.getInt(1);
            }
        }catch(SQLException sql){
            sql.printStackTrace();
        }
        return count;
    }
}
