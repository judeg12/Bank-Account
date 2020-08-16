//CheckingAccount is subclass of BankAccount 

public class CheckingAccount extends BankAccount{
  
  //data field
  private double monthlyFee;
  
  //constructor 
  public CheckingAccount(int accountNo1, String customerName1, double balance1, double monthlyFee){
 
    super(accountNo1, customerName1, balance1);
    this.monthlyFee = monthlyFee;
  }
  
  /**
   * @return double
   * getter for monthly fee
   */
  public double monthlyFee(){
    return this.monthlyFee;
  }
  
  /**
   * @param double 
   * setter for monethly fee
   */
  public void setMonthlyFee(double monthlyFee){
    this.monthlyFee = monthlyFee;
  }
  
  /**
   * no param or return 
   * Decuts monthly fee from balance 
   * Throws Insufficent Funds exception 
   */ 

  public void applyFee() throws InsufficientFundsException{
    if(balance >= monthlyFee){
	balance = balance - monthlyFee;
    }  
    else{ //when balance goes below zero
	throw new InsufficientFundsException();
    }
  } 
  

/**
*toString method will call superclass toString and add monthly fee info
*@return String
*/
@Override 
  public String toString(){
    return super.toString() + "\t"+ "      Monthly fee: $\t"+ monthlyFee;
  }
}