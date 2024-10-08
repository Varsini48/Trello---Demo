package com.hexawrae.shopsmart.entity;

import com.hexaware.shopsmart.exception.InsufficientPaymentException;

public abstract class Payment 
{
	protected String payerName;
	protected double amount;
	
	public Payment(String payerName, double amount)
	{
		this.payerName=payerName;
		this.amount=amount;
	}
	public abstract void processPayment() throws InsufficientPaymentException;
}
