package com.capgemini.pecunia.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.capgemini.pecunia.validation.AccountNumber;
import com.capgemini.pecunia.validation.Amount;
import com.capgemini.pecunia.validation.LoanAndSlipId;

public class LoanTranscationForm {
	@LoanAndSlipId
	private long loanId;
	@AccountNumber
	private long accountNo;
	@Amount
	private double amount;
	public LoanTranscationForm() {
		super();
	}
	public LoanTranscationForm(long loanId,long accountNo, double amount) {
		super();
		this.loanId=loanId;
		this.accountNo = accountNo;
		this.amount = amount;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	@Override
	public String toString() {
		return "LoanTranscationForm [loanId=" + loanId + ", accountNo=" + accountNo + ", amount=" + amount + "]";
	}
	
	
}
