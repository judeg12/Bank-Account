/**
*@author Jude 
*Project2 
*SavingsAccount is a sublcass of BankAccount
*/ 

public class SavingsAccount extends BankAccount{
  //data-->
  private double interestRate;
  
  //four arg constructor 
  SavingsAccount(int accountNo, String customerName, double balance, double interestRate){
    super(accountNo, customerName, balance); //super class constructor 
    this.interestRate=interestRate;
  }
  //three arg constructor
  SavingsAccount(int accountNum, String customerName, double interestRate){
    super(accountNum, customerName); 
    this.interestRate = interestRate; 
  }
  
  //three arg constructor 
  
  /**
   * @return double 
   * getter for interest rate
   */
  public double getInterestRate(){
    return interestRate;
  }
  
  /**
   * Assess the interest earned and adds to balance
   */
  public void accrueInterest(){
    super.balance *= (1+this.interestRate);
  }
  
  /**
   * @return String
   * prints information for class
   * also prints superlclass's toString    
   */
@Override 
  public String toString(){
    return super.toString() + "Interest rate:\t" + (this.interestRate*100.0) + "%";
  }
}