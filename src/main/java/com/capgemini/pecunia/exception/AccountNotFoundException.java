package com.capgemini.pecunia.exception;

public class AccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public AccountNotFoundException() {
		
	}
	public AccountNotFoundException(String str) {
		super(str);
	}
}
