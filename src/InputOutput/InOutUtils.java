package InputOutput;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by rrolando on 1/15/17.
 */
public class InOutUtils {

    public static final String INPUT = "/Users/rrolando/JavaAdvanced/src/InputOutput/input.txt";
    public static final String OUTPUT = "/Users/rrolando/JavaAdvanced/src/InputOutput/output.txt";
    public static final String CSV = "/Users/rrolando/JavaAdvanced/src/InputOutput/Country.csv";

    public void duplicateFileStream(){
        int i = 0;
        int count = 0;
        byte[] b = new byte[1];

        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream(INPUT);
            out = new FileOutputStream(OUTPUT);

            System.out.println("Bytes read: "+in.available());

            while((i = in.read(b)) != -1){
                out.write(b);
                count+=1;
            }


            System.out.println("Bytes written: "+count);

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
        int i = 0;
        int count = 0;

        char[] c = new char[10];

        FileReader in = null;
        FileWriter out = null;

        try{
            in = new FileReader(INPUT);
            out = new FileWriter(OUTPUT);

            while((i = in.read(c)) != -1){
                out.write(c);
                count+=1;
            }


            System.out.println("Bytes written: "+count);

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
        String s = null;

        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.print("Enter text (q to exit): ");
                s = br.readLine();
                if(s.equals("q") || s.length() == 0){
                    System.exit(0);
                }
                System.out.println("Read: "+s.trim());
            }while (s != null);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void consoleScannerRegex(){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Please enter your first name: ");
            String strName = scanner.next("^[A-Za-z]+$");
            System.out.print("\nPlease enter your last name: ");
            String strLast = scanner.next("[A-Za-z]+$");
            System.out.println("Your full name is: "+strName+" "+strLast);
        }catch(InputMismatchException im){
            System.out.println("You must enter only letters! Please try again...");
            consoleScannerRegex();
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
        System.out.println("Your name is: "+strFullName);
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



}
