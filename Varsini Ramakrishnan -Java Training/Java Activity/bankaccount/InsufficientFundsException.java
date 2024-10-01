package com.hexaware.exceptionhandling.bankaccount;

public class InsufficientFundsException extends Exception{
	public InsufficientFundsException(String message)
	{
		super(message);
	}

}
