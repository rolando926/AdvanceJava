package InOut;

/**
 * Created by RXC8414 on 1/17/2017.
 */
public class InOutMain {
    public static void main(String[] args) {
        InOutUtils io = new InOutUtils();
        //io.duplicateFileStream();
        //io.duplicateFileReader();
        //io.duplicateFileBuffered();
        //io.consoleBufferedReader();
        //io.consoleScannerRegex();
        //io.consoleScannerRegexWithSpaces();
        //io.consoleReadUserCredentials();
        //io.csvParser();
        //io.readConfigFromProp();
        //io.createExcelFile();
        //io.readExcelSheet(0);
        io.modifyExcelSheetByRowCol(4,2,0,"1");

        System.out.println("\nThe program is done!");
    }
}
