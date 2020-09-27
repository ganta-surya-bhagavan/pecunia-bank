package com.capgemini.pecunia.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.capgemini.pecunia.validation.AccountNumber;
import com.capgemini.pecunia.validation.Amount;
import com.capgemini.pecunia.validation.LoanAndSlipId;

public class SlipTranscationForm {

	@LoanAndSlipId
	private long slipId;
	@AccountNumber
	private long accountNo;
	@Amount
	private double amount;
	
	public SlipTranscationForm() {
		super();
	}

	public SlipTranscationForm(long accountNo, double amount,long slipId) {
		super();
		this.accountNo = accountNo;
		this.amount = amount;
		this.slipId=slipId;
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
	
	public long getSlipId() {
		return slipId;
	}

	public void setSlipId(long slipId) {
		this.slipId = slipId;
	}

	@Override
	public String toString() {
		return "SlipTranscationForm [slipId=" + slipId + ", accountNo=" + accountNo + ", amount=" + amount + "]";
	}

	
	
}
