import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ATM_Transaction {
    public static void main(String args[]) throws IOException {

        int balance = 0, withdraw, deposit;
        int mainbalance = 0;
        Scanner s = new Scanner(System.in);
        try {
            File file = new File("ATM.txt");

            Scanner inputtext = new Scanner(file);
            while (inputtext.hasNextLine()) {

                balance = Integer.parseInt(inputtext.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Automated Teller Machine");
            System.out.println("****************************");

            System.out.println("Choose 1 for Withdraw:-");
            System.out.println("Choose 2 for Deposit:-");
            System.out.println("Choose 3 for Check Balance:-");
            System.out.println("Choose 4 for delete:-");

            System.out.println("Choose 5 for EXIT");
            System.out.print("Choose the operation you want to perform:");
            int n = s.nextInt();
            switch (n) {
                case 1:
                    System.out.print("Enter money to be withdrawn:");
                    withdraw = s.nextInt();

                    String oldLine = String.valueOf(balance);
                    int remainingBalance = 0;
                    if (balance >= withdraw) {
                        remainingBalance = balance - withdraw;

                    }
                    String filePath = "C:/Users/arkha/Desktop/bkash/ATM.txt";
                    // Instantiating the Scanner class to read the file
                    Scanner sc = new Scanner(new File(filePath));
                    // instantiating the StringBuffer class
                    StringBuffer buffer = new StringBuffer();
                    // Reading lines of the file and appending them to StringBuffer
                    while (sc.hasNextLine()) {
                        buffer.append(sc.nextLine() + System.lineSeparator());
                    }
                    String fileContents = buffer.toString();
                    // closing the Scanner object
                    sc.close();
                    String newLine = String.valueOf(remainingBalance);
                    // Replacing the old line with new line
                    fileContents = fileContents.replaceAll(oldLine, newLine);
                    // instantiating the FileWriter class
                    FileWriter writer = new FileWriter(filePath);
                    System.out.println("");
                    writer.append(fileContents);
                    writer.flush();
                    balance = remainingBalance;
                    if (balance <= 0) {
                        System.out.println("you don't hava sufficent balance:");
                    }
                    break;

                case 2:
                    System.out.print("Enter money to be deposited:");
                    deposit = s.nextInt();
                    if (deposit < 0) {
                        System.out.println("Invalid amount!");
                    } else {
                        int olddeposit = balance;
                        balance = balance + deposit;

                        String old = String.valueOf(olddeposit);
                        String fileP = "C:/Users/arkha/Desktop/bkash/ATM.txt";
                        Scanner intr = new Scanner(new File(fileP));
                        StringBuffer buf = new StringBuffer();
                        while (intr.hasNextLine()) {
                            buf.append(intr.nextLine() + System.lineSeparator());
                        }
                        String fileCon = buf.toString();
                        System.out.println("Contents of the file: " + fileCon);
                        // closing the Scanner object
                        intr.close();
                        String newL = String.valueOf(balance);
                        // Replacing the old line with new line
                        fileCon = fileCon.replaceAll(old, newL);
                        // instantiating the FileWriter class
                        FileWriter writ = new FileWriter(fileP);
                        System.out.println("");
                        System.out.println("new data: " + fileCon);
                        writ.append(fileCon);
                        writ.flush();
                        // FileWriter myobj = new FileWriter("Deposite.txt");
                        // myobj.write(String.valueOf(balance));
                        System.out.println("Your Money has been successfully depsited");
                        System.out.println("");
                        System.out.println("your balance : " + balance + " has been deposited.");
                        System.out.println("**********************************************");

                    }

                    break;

                case 3:
                    System.out.println("Balance : " + balance);
                    System.out.println("");
                    System.out.println("your new balance is: " + balance);
                    System.out.println("*************************");

                    break;

                case 4:

                    String oldre = String.valueOf(balance);
                    String filePr = "C:/Users/arkha/Desktop/PK1/ATM.txt";
                    Scanner intrt = new Scanner(new File(filePr));
                    StringBuffer bufr = new StringBuffer();
                    while (intrt.hasNextLine()) {
                        bufr.append(intrt.nextLine() + System.lineSeparator());
                    }
                    String fileCont = bufr.toString();
                    // closing the Scanner object
                    intrt.close();
                    // Replacing the old line with new line

                    fileCont = fileCont.replaceAll(oldre, "0");
                    // instantiating the FileWriter class
                    FileWriter writr = new FileWriter(filePr);
                    System.out.println("");
                    System.out.println("new data: " + fileCont);
                    writr.append(fileCont);
                    writr.flush();
                    // FileWriter myobj = new FileWriter("Deposite.txt");
                    // myobj.write(String.valueOf(balance));
                    System.out.println("Your Balance has sucessfully deleted!");
                    System.out.println("****************************************");

                    System.out.println("Balance equals 0  ");
                    System.out.println("*************************");

                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}