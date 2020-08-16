import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestBank{
  public static void main(String [] args) throws FileNotFoundException{
   //check for one command line args
	if(args.length != 1){
	  System.exit(1); //exit 
	}
	
   //create objects
	File inputFile = new File(args[0]);
	File outputFile = new File("bankSummary.txt");
	PrintWriter Writer = null;
      try{
	Writer = new PrintWriter(outputFile);
	}catch (FileNotFoundException e){
	   System.out.println("Output file is deleted");
	}
   //creates new bank Lehigh Lender 
	Bank myBank = new Bank("Lehigh Lender");

   //reads accounts -- .nextLine() -- .nextString() -- saves
	try{
	  myBank.loadAccounts(inputFile);
	} catch (IOException e){
	  System.out.println("Input file is not fouund");
	}
   //accrue interest and apply fee
	myBank.accrueInterest();
	myBank.applyFee();
   //prints monthly summary to new file named bankSummary.txt
	Writer.println(myBank.toString());
	
   //close objects
	Writer.close();
  }
}