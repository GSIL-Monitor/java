package com.exception;

public class BankCheck {
	private double balance = 1000;
	public void check() {
		System.out.println("balance: " + balance);

	}

	public void withdrow(double amount) throws MyException {
		if (amount <= balance) {
			balance -= amount;
			System.out.println("balance after withdrow : " + balance);
		} else {
			double needs = amount - balance;
			throw new MyException(needs);
		}

	}
}
