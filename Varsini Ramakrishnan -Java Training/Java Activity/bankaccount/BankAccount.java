package com.hexaware.exceptionhandling.bankaccount;

public class BankAccount {
	
	private String name;
	private double balance;
	
	public BankAccount(String name, double balance)
	{
		if(balance<=0)
		{
			System.out.println("Initial balance cannot be zero");
		}
		
		this.name=name;
		this.balance=balance;
		
	}

	public void deposit(double amount) throws InvalidAmountException
	
	{
		if(amount<=0)
		{
			throw new InvalidAmountException("Deposit amount should be greater than 0");
		}
		 
		else
			balance+=amount;
	}
	
	public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException
	{
		if(amount < 0)
		{
			throw new InvalidAmountException("Withdraw amount should be greater than 0");
		}
		
		else if(balance < amount)
		{
			throw new InsufficientFundsException("Balance is less than the withdrawing amount");
		}
		
		else
		{
			balance-=amount;
			System.out.println("the amount has been withdrawn successfully and your current balance is " + balance);
		}
	}
	
	public void checkBalance()
	{
		System.out.println("Your account balance is " + balance);
	}
}
