package edu.neu.csye6200;

public abstract class AccountAPI {

	private int accountNumber;
	private double balance ;
	
	abstract public int getAccountNumber() ;
	abstract public void setAccountNumber(int accountNumber) ;
	abstract public double getBalance() ;
	abstract public void setBalance(double balance) ;
	
}
