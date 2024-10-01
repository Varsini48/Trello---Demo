package com.hexaware.exceptionhandling.bankaccount;

import java.util.*;
public class BankAccountManagement {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		BankAccount acc=null;
		boolean exit=false;
		
		
		while(!exit)
		{
			System.out.println("Enter your choice : ");
			System.out.println("1. Create new account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Check Balance");
			System.out.println("5. Exit");
			int choice=sc.nextInt();
		
		try
		{
			switch(choice)
			{
			case 1:
				System.out.println("Enter name: ");
				String name=sc.nextLine();
				System.out.println("Enter initial balance: ");
				double balance=sc.nextDouble();
				
				System.out.println("Account created successfully for " + name);
				acc=new BankAccount(name, balance);
				break;
				
				
			case 2:
				if(acc==null)
					throw new NullPointerException("No such account exist");
				
				else
				{
					System.out.println("Enter amount to be deposited: ");
					double amount=sc.nextDouble();
					acc.deposit(amount);
					
				}
				break;
				
			case 3:
				if(acc==null)
					throw new NullPointerException("No such account exist");
				
				else
				{
					System.out.println("Enter amount to be Withdrawn: ");
					double amount=sc.nextDouble();
					acc.withdraw(amount);
					
				}
				break;
				
			case 4:
				if(acc==null)
					throw new NullPointerException("No such account exist");
				else
			
				acc.checkBalance();
				break;
				
			case 5:
				exit=true;
				System.out.println("thank you !");
				break;
				
			default:
				throw new InvalidChoiceException("Enter a valid choice");
				
				
				
				
			}
		}
		catch(InvalidChoiceException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidAmountException e1)
		{
			System.out.println(e1.getMessage());
		}
		catch(InsufficientFundsException e2)
		{
			System.out.println(e2.getMessage());
		}
		catch(NullPointerException e3) {
			System.out.println(e3.getMessage());
		}
		
	
	}
		sc.close();
	

}
}
