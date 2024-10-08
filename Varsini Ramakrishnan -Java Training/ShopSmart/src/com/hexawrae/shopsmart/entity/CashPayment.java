package com.hexawrae.shopsmart.entity;

import com.hexaware.shopsmart.exception.InsufficientPaymentException;

public class CashPayment extends Payment
{
	private double cashReceived;
	public CashPayment(String payerName, double amount, double cashReceived)
	{
		super(payerName, amount);
		this.cashReceived=cashReceived;
		
	}
	
	public void processPayment() throws InsufficientPaymentException
	{
		if (amount <=0)
		{
			throw new InsufficientPaymentException("Amount is less for payment through Cash");
		}
		
		System.out.println(" Cash Payment successfull");
	}
	

}
