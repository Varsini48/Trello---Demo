package com.hexawrae.shopsmart.entity;

import com.hexaware.shopsmart.exception.InsufficientPaymentException;

public class CreditCardPayment extends Payment
{
	private String cardNumber;
	
	public CreditCardPayment(String payerName, double amount, String cardNumber)
	{
		super(payerName, amount);
		this.cardNumber=cardNumber;
	}
	
	public void processPayment() throws InsufficientPaymentException
	{
		if (amount <=0)
		{
			throw new InsufficientPaymentException("Aount is less for payment through creditcard");
		}
		
		System.out.println("CreditCard Payment successfull");
	}
	

}
