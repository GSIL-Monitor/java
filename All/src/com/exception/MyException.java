package com.exception;

public class MyException extends Exception {
	double amount;
	MyException(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
}
