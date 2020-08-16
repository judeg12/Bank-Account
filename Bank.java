import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * @author Jude Gerhart 
 * @written June 8th, 2020
 * code for project 2 
 */

public class Bank{
  /*  data field for Bank */
  private String name;
  private BankAccount accounts[]; // arrray containing all accounts 
  private int totalAccounts;
  final public int ACCT_CAPACITY=20; 
  
  //one arg constructor 
  public Bank(String name){
    this.name = name;
    this.totalAccounts = 0;
    this.accounts = new BankAccount[ACCT_CAPACITY];
  }
  
  /**
   * @return String name
   * getter for bank name 
   */
  public String getName(){
    return name;
  }
  
  /**
   * @param BankAccount object
   * adds new bank account to accounts array
   */
  public void addAccount(BankAccount newAcct){
    if(totalAccounts==20){
	File outputFile = new File("bankSummary.txt");  //creates file and prints the error to file 
       PrintWriter Writer = null; //create write
      try{
	Writer = new PrintWriter(outputFile); //set writer equal to 
	}catch (FileNotFoundException e){
	   System.out.println("Output file is deleted"); //error 
	}
	Writer.println("The maximum number of accounts is 20, this bank has reached it's max"); // message 
    System.out.println("Max number of accounts has been reached.");
    }
    else{
      accounts[totalAccounts] = newAcct;
      totalAccounts++;
    }
  }
  
  /**
   * No input 
   * PrintBankSummary prints bank name and info about each account
   * one account per line
   */
  public void PrintBankSummary(){
    System.out.println("Bank Name: "+ name);
    //loop moves through all accounts 
    for (int i=0; i<totalAccounts; i++){
      System.out.println(accounts[i].toString()); //prints individually
    }
  }

  /**
   * no input or output 
   * AccureInterest will apply and add one month's interest to each savings account
   * using repective InterestRate
   */

  public void accrueInterest(){
     for (int i=0; i<totalAccounts; i++){
	 //if acount is a savings account, accrue interest. Otherwise skip
       if(accounts[i] instanceof SavingsAccount){
          ((SavingsAccount) accounts[i]).accrueInterest(); //adds interest
       } 
    }
  }

  /**
   * no input or output
   * applyFee will assesss the monthlyfee to checking account 
   */
  public void applyFee(){
    for (int i=0; i<totalAccounts; i++){
	//if account is a checking account, apply fee. Otherwise skip
      if(accounts[i] instanceof CheckingAccount){
         ((CheckingAccount) accounts[i]).applyFee(); //applies fee to each account
      }
    }
  }
  /**
  *@param File account file 
  *takes a file as input and reads the file for bank information. 
  *Method then passes the info to respective objects in account array
  */
  public void loadAccounts(File acctFile) throws IOException{
	  //create file input 
	Scanner myScanner = null;
	File accountFile = null;
	try{
	  accountFile = acctFile; 
	  myScanner = new Scanner(accountFile);
	} catch(Exception e){
		System.out.println("File not found in loadAccounts method" + e.getMessage());
	} 
	
	  //interpret file
      while(myScanner.hasNext()){
	if(myScanner.hasNextLine()){
	 String accountType = myScanner.next();
	System.out.println(accountType); 
	 int accountNum = myScanner.nextInt();
	System.out.println(accountNum);
	 String name = myScanner.next() + " " + myScanner.next();
	System.out.println(name);
	 double accountBalance = myScanner.nextDouble();
	System.out.println(accountBalance);
	 double rate = myScanner.nextDouble();
	System.out.println(rate);
	
	  //save information into objects 
	if (accountType.equals("S")){ //will only return true if letter is upper case
	  SavingsAccount account1 = new SavingsAccount(accountNum, name, accountBalance, rate);
	  addAccount(account1);
	}
	else if (accountType.equals("C")){
	  CheckingAccount account1 = new CheckingAccount(accountNum, name, accountBalance, rate);
	  addAccount(account1);
	}
	else{
	  throw new UnknownAccountException(); //exception will print message to file output 
	}
       }
      } //end while

	myScanner.close();
  }
  /**
  *@return String prints bank account summary 
  * with spacing in bewtween 
  */
@Override 
  public String toString(){
	String output = "";
	for (int i=0; i<totalAccounts; i++){
	output += accounts[i].toString() + "\n";
	}
     return output;
  }
}//end of bank class


//composition relationship between class "Bank" and "BankAccount"

class BankAccount{
  protected int accountNo;
  protected String customerName;
  protected double balance;
  //two arg constructor 
  public BankAccount(int accountNo, String customerName){
    this.accountNo = accountNo;
    this.customerName = customerName; 
    this.balance = 0;
  }
  //three arg constructor 
  public BankAccount(int accountNo, String customerName, double balance){
    this.accountNo = accountNo;
    this.customerName = customerName; 
    this.balance = balance; 
  }
  
  /**
   * getter for account number 
   * @return int 
   */
  public int getAccountNum(){
    return accountNo;
  }
  
  /**
   * getter for customer name 
   * @return String 
   */
  public String getCustomerName(){
    return customerName;
  }
  
  /**
   * getter for balance
   * @return double
   */
  public double getBalance(){
    return balance;
  }
  
  /**
   * deposit adds money amount to balance
   * @param double 
   */
  public void deposit(double amt){
    balance = balance + amt; 
  }
  
  /**
   * toString prints info about account
   */
@Override 
  public String toString(){
    return accountNo+"\t" + customerName+"\t" + ((double)(Math.round(balance*100))/100.0)+"\t";
  }
}
