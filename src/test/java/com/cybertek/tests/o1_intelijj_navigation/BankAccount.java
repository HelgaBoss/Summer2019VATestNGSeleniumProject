package com.cybertek.tests.o1_intelijj_navigation;

public class BankAccount {
//	create a custom class for BankAccount
//
//	attributes/data that can have are: 
//					1. AccountHolder, 2. AccountNumber, 3. Balance
//
//		Actions: deposit, withdraw, showBalance
//
//		requiremnts: 
//			1. user should be able to deposit money into their account
//
//			2. user should be able to withdraw money from their account
//					2.1 if the withdrawing account is greater than available balance, 35$ charge will be added
//
//					2.2 if the balance is less than 0, user should not be able to withdraw money
//
//			3. user should be able to see their balance

//	instance variable: declared in the class, outside of any methods(object variables)
//	instance method

	String AccountHolder;
	long AccountNumber;
	double balance;
	
	String username, password;
	
	public BankAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public BankAccount() {
		
	}
	
	public BankAccount(String name, long acctNum) {
		
		AccountHolder = name;
		AccountNumber = acctNum;
	}

	public void ShowBalance() {
		System.out.println("------------------------------------------");
		String acct = "" + AccountNumber;
		String AccountNumber = "************" + acct.substring(12);
		System.out.println("Account Holder: " + AccountHolder);
		System.out.println("Account number: " + AccountNumber);
		System.out.println("Available Balance: $" + balance);

	}

	public void Deposit(double amount) {

		System.out.println("-------------------------------------------");
		String acct = "" + AccountNumber;
		String AccountNumber = "************" + acct.substring(12);
		System.out.println("Depositing $ " + amount + " to account " + AccountNumber);
		balance += amount;
	}

	public void WithDraw(double amount) {
		System.out.println("-------------------------------------------");

		if (balance <= 0) {
			System.out.println("No available balance");
		}
		String acct = "" + AccountNumber;
		String AccountNumber = "************" + acct.substring(12);
		System.out.println("WithDrawing $ " + amount + " from the account " + AccountNumber);
		balance -= amount;

		if (balance < 0) {
			balance -= 35;
		}
		System.out.println("New balance " + balance);

		System.out.println("--------------------------------------------");

	}

	public void accountSetUp(String name, long acctNum) {

		AccountHolder = name;
		AccountNumber = acctNum;
		
	}
	
	

}
