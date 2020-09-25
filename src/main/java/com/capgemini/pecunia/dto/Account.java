package com.capgemini.pecunia.dto;

public class Account {
	private long accountId;
	private long aadhar;
	private int amount;
	private String IFSC;
	private int branchId;
	private String status;
	private String accountType;
	public Account() {
		super();
	}
	public Account(long accountId, long aadhar, int amount, String iFSC, int branchId, String status,
			String accountType) {
		super();
		this.accountId = accountId;
		this.aadhar = aadhar;
		this.amount = amount;
		IFSC = iFSC;
		this.branchId = branchId;
		this.status = status;
		this.accountType = accountType;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", aadhar=" + aadhar + ", amount=" + amount + ", IFSC=" + IFSC
				+ ", branchId=" + branchId + ", status=" + status + ", accountType=" + accountType + "]";
	}
	
}
