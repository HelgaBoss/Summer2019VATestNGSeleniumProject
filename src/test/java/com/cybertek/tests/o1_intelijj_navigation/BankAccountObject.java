package com.cybertek.tests.o1_intelijj_navigation;

public class BankAccountObject {

	public static void main(String[] args) {

		BankAccount account1 = new BankAccount();
		account1.AccountHolder = "Erhan Dolapci";
		account1.AccountNumber = 1234354353431116L;

		account1.ShowBalance();

		account1.Deposit(2000);

		account1.Deposit(4000);

		account1.WithDraw(3000);
		account1.WithDraw(3001); // New balance -36.0
		account1.WithDraw(2000);
		account1.Deposit(2000000);

		BankAccount account2 = new BankAccount();
		account2.accountSetUp("Muaz Gulen", 1234567893333345L);

		account2.ShowBalance();
		
		account2.Deposit(1000000);
		account1.WithDraw(500000);

		
		
		BankAccount account3 = new BankAccount("Nadire Pillot", 1232324563422324L);
		
		account3.ShowBalance();
		
		account3.Deposit(10);
		account3.WithDraw(20);
		
		
		
	}
}
