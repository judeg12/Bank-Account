/**
*@Author Jude Gerhart
*@Written 6/12/2020
*This class is an custom exception for project 2
*Thrown when account balance goes negative
*/
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class InsufficientFundsException extends RuntimeException{
  public InsufficientFundsException(){
	 super("Account balance has gone below zero."); 
	PrintWriter Writer = null;
	File outputFile = null;
      try{
	outputFile = new File("bankSummary.txt");
	Writer = new PrintWriter(outputFile);
	}catch (FileNotFoundException e){
	   System.out.println("Output file is deleted");
	}
	 Writer.println("Account balance has gone below zero.");
  }
}