package com.capgemini.pecunia.exception;

public class InSufficientBalanceException extends Exception {
	private static final long serialVersionUID = 1L;
	public InSufficientBalanceException() {
		
	}
	public InSufficientBalanceException(String str) {
		super(str);
	}
}
