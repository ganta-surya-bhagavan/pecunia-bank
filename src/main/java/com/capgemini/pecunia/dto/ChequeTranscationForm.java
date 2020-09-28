package com.capgemini.pecunia.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.capgemini.pecunia.validation.AccountNumber;
import com.capgemini.pecunia.validation.Amount;

public class ChequeTranscationForm {
	@AccountNumber
	private long payeeAccountNo;
	@Amount
	private double amount;
	@Min(value=100000,message="chequeNo cant be more than 6 digits")
	@Max(value=999999,message="chequeNo cant be more than 6 digits")
	private int chequeNo;
	//@NotEmpty(message="IFSC code cant be empty")
	@Pattern(regexp="^[A-Z]{4}0[A-Z0-9]{5}$", message="Invalid IFSC code")
	private String ifscCode;
	private LocalDate issueDate;
	public ChequeTranscationForm() {
		super();
	}
	public ChequeTranscationForm(long payeeAccountNo, double amount, int chequeNo, String ifscCode,
			LocalDate issueDate) {
		super();
		this.payeeAccountNo = payeeAccountNo;
		this.amount = amount;
		this.chequeNo = chequeNo;
		this.ifscCode = ifscCode;
		this.issueDate = issueDate;
	}
	public long getPayeeAccountNo() {
		return payeeAccountNo;
	}
	public void setPayeeAccountNo(long payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIFSCcode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	@Override
	public String toString() {
		return "ChequeTranscationForm [payeeAccountNo=" + payeeAccountNo + ", amount=" + amount + ", chequeNo="
				+ chequeNo + ", IFSCcode=" + ifscCode + ", issueDate=" + issueDate + "]";
	}
	
}
