package InOut;

import java.io.*;
import java.io.File;
import java.util.*;

import org.apache.poi.hssf.usermodel.examples.CellTypes;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;




/**
 * Created by RXC8414 on 1/17/2017.
 */
public class InOutUtils {

    public static final String INPUT = "C:\\AdvanceJava\\src\\InOut\\Resources\\input.txt";
    public static final String OUTPUT = "C:\\AdvanceJava\\src\\InOut\\Resources\\output.txt";
    public static final String CSV = "C:\\AdvanceJava\\src\\InOut\\Resources\\Country.csv";
    private static final String XLSX = "C:\\AdvanceJava\\src\\InOut\\Resources\\Excel.xlsx";
    private static final String CLASS_PROP = "C:\\AdvanceJava\\src\\InOut\\Resources\\class.properties";

    public static final int SIZE = 21;

    Properties prop = new Properties();

    int counter = 1;
    int counterScanner = 0;
    boolean blnExit = false;

    public void duplicateFileStream(){
        int i = 0;
        int count = 0;
        byte[] b = new byte[SIZE];
        byte[] b1 = new byte[1];

        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream(INPUT);
            out = new FileOutputStream(OUTPUT);

            System.out.println("Bytes read: "+in.available());

            while((i = in.read(b)) != -1){
                out.write(b);
                if(in.available() < SIZE) {
                    while((i = in.read(b1)) != -1){
                        out.write(b1);
                    }
                }
                //count += 1;
            }
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }finally {
            try{
                if(in != null && out != null){
                    in.close();
                    out.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void duplicateFileReader(){
        char[] c = new char[1];
        char[] c1 = new char[1];
        int i;

        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader(INPUT);
            out = new FileWriter(OUTPUT);

            while((i = in.read(c)) != -1){
                if(c[0] == 'a'){
                    out.write('*');
                }
                else {
                    out.write(c);
                }
            }

        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }finally {
            try{
                if(in != null && out != null){
                    in.close();
                    out.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void duplicateFileBuffered(){
        String line = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            br = new BufferedReader(new FileReader(INPUT));
            bw = new BufferedWriter(new FileWriter(OUTPUT));

            while((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }

        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try {
                br.close();
                bw.close();
            }catch(IOException io){
                io.printStackTrace();
            }

        }

    }

    public void consoleBufferedReader(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        String s = null;

        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new FileWriter(OUTPUT));

            do{
                System.out.print("Enter text (q to exit): \n");
                s = br.readLine();
                if(s.equals("q") || s.length() == 0){
                    break;
                }
                System.out.println("Read: "+s.trim());
                bw.write(s);
                bw.newLine();
            }while (s != null);

        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try {
                bw.close();
                br.close();
            }catch(IOException io){
                io.printStackTrace();
            }

        }
    }
    //1. Make it work
    //2. Refactor to only accept one upper letter as first char for both (first and last)
    //3. Add counter to number of trials (must use System.exit(0) when counter hits maximum)

    public void consoleScannerRegex(){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Please enter your first name: \n");
            String strName = scanner.next("^[A-Z]{1}[a-z]+$");
            System.out.print("\nPlease enter your last name: \n");
            String strLast = scanner.next("[A-Z]{1}[a-z]+$");
            System.out.println("Your full name is: "+strName+" "+strLast);
        }catch(InputMismatchException im){
            counter++;
            if(counter == 3){
                System.out.println("You must enter only letters! This is your last trial! ");
                consoleScannerRegex();
            }else if(counter > 3){
                System.exit(0);
            }else {
                System.out.println("You must enter only letters! This is trial " + counter + " of 3. Please try again...");
                consoleScannerRegex();
            }
        }
    }

    public void consoleScannerRegexWithSpaces(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String strFullName = scanner.nextLine();
        if(!strFullName.matches("[a-zA-Z ]+")){
            System.out.println("You must enter only letters and/or spaces! Please try again...");
            consoleScannerRegexWithSpaces();
        }
        if (counterScanner == 0) {
            System.out.println("Your name is: " + strFullName);
            counterScanner++;
        }

    }

    public void consoleReadUserCredentials(){
        Console console = System.console();
        if(console == null){
            System.out.println("No console: non-interactive mode!");
            System.exit(0);
        }

        System.out.print("Enter your username: ");
        String username = console.readLine();

        System.out.print("Enter your password: ");
        char[] password = console.readPassword();

        System.out.println("--------------------");
        System.out.println("username: "+username);
        System.out.println("password: "+new String(password));
    }


    public void csvParser(){
        String line = "";
        String csvSplit = ",";
        //Using try-resources
        try(BufferedReader br = new BufferedReader(new FileReader(CSV))){
            while((line = br.readLine()) != null){
                String[] column = line.split(csvSplit);
                System.out.println("Country [code= " + column[4] + " , name=" + column[5] + "]");
            }
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void readPropertiesFile(){
        try(FileReader file = new FileReader(CLASS_PROP);
            BufferedReader bReader = new BufferedReader(file);){
            prop.load(bReader);
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void readConfigFromProp(){
        readPropertiesFile();
        String values = Arrays.asList(prop).toString();
        System.out.println(values);
        System.out.println("----------------------");
        System.out.println("url = "+ prop.getProperty("url"));
        System.out.println("browser = "+prop.getProperty("browser"));
        System.out.println("departmentMainMenu = "+prop.getProperty("departmentMainMenu"));
    }

    public void createExcelFile(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object column : datatype) {
                Cell cell = row.createCell(colNum++);
                if (column instanceof String) {
                    cell.setCellValue((String) column);
                } else if (column instanceof Integer) {
                    cell.setCellValue((Integer) column);
                }
                //Add the other instances Byte, Short, Double, Float, Char, Boolean and Formula
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(XLSX);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readExcelSheet(int sheet){
        try {
            FileInputStream excelFile = new FileInputStream(new File(XLSX));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(sheet);

            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellType() == currentCell.CELL_TYPE_STRING) {
                        System.out.print(currentCell.getStringCellValue() + ", ");
                    }
                    else if (currentCell.getCellType() == currentCell.CELL_TYPE_NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + ", ");
                    }
                }
                System.out.println();
            }
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void modifyExcelSheetByRowCol(int row, int col, int sheet, String newValue){
        try {
            FileInputStream excelFile = new FileInputStream(new File(XLSX));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(sheet);
            Cell currentCell = null;

            XSSFRow sheetrow = (XSSFRow) datatypeSheet.getRow(row);
            if(sheetrow == null){
                sheetrow = (XSSFRow) datatypeSheet.createRow(row);
            }
            currentCell = sheetrow.getCell(col);

            if(currentCell == null){
                currentCell = sheetrow.createCell(col);
            }

            currentCell.setCellValue(Double.parseDouble(newValue));

            excelFile.close();

            FileOutputStream outExcelFile = new FileOutputStream(XLSX);
            workbook.write(outExcelFile);
            outExcelFile.close();

        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

}
