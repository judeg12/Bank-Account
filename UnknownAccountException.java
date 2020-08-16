/**
*@Author Jude Gerhart
*@Written 6/12/2020
*This class is an custom exception for project 2
*Thrown when account type is not recognized as either S or C
*/

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class UnknownAccountException extends RuntimeException{
  public UnknownAccountException(){
	super("Account type can not be determined"); //prints to console
	PrintWriter Writer = null;
	File outputFile = new File("bankSummary.txt");
	try{
	 Writer = new PrintWriter(outputFile);
	}catch (FileNotFoundException e){
	   System.out.println("Output file is deleted");
	}
	Writer.println("Account type can not be determined"); //writes to output file
  }
}