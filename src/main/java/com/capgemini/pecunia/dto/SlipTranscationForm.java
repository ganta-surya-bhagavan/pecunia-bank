package com.capgemini.pecunia.dto;

public class SlipTranscationForm {
	private long slipId;
	private long accountNo;
	private int amount;
	
	public SlipTranscationForm() {
		super();
	}

	public SlipTranscationForm(long accountNo, int amount,long slipId) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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
