package com.capgemini.pecunia.dto;

public class Account {
private long accountNo;
private long aadhar;
private double amount;
private String ifsc;
private String status;
private String accountType;
private int branchId;
public Account(long accountNo,long aadhar, double amount, String ifsc, String status, String accountType,
		int branchId) {
	super();
	this.accountNo=accountNo;
	this.aadhar = aadhar;
	this.amount = amount;
	this.ifsc = ifsc;
	this.status = status;
	this.accountType = accountType;
	this.branchId = branchId;
}
public Account() {
	super();
}

public long getAccountNo() {
	return accountNo;
}
public long getAadhar() {
	return aadhar;
}
public void setAadhar(long aadhar) {
	this.aadhar = aadhar;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
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
public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}


}
