package JDBC;

/**
 * Created by RXC8414 on 1/30/2017.
 */
public class dbMain {
    public static String strQuery = "select * from tblemployee";

    public static void main(String[] args) {
        dbUtils db = new dbUtils();
        //db.getDataSet(strQuery);
        System.out.println("Record Count = "+db.getRecordCount(strQuery));
        //db.doUpdateInsert(strQuery);
    }
}
