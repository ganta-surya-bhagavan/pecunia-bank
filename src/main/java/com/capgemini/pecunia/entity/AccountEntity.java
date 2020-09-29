package com.capgemini.pecunia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pecunia_bank_account")
public class AccountEntity {
	@Id
	@Column(name="account_id")
	private Long accountId;
	@Column(name="aadhar")
	private long aadhar;
	@Column(name="amount")
	private double amount;
	@Column(name="IFSC")
	private String ifsc;
	@Column(name="branch_id")
	private int branchId;
	@Column(name="status")
	private String status;
	@Column(name="account_type")
	private String accountType;
	public AccountEntity() {
		super();
	}
	public AccountEntity(long accountId, long aadhar, double amount, String ifsc, int branchId, String status,
			String accountType) {
		super();
		this.accountId = accountId;
		this.aadhar = aadhar;
		this.amount = amount;
		this.ifsc = ifsc;
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
		return "Account [accountId=" + accountId + ", aadhar=" + aadhar + ", amount=" + amount + ", IFSC=" + ifsc
				+ ", branchId=" + branchId + ", status=" + status + ", accountType=" + accountType + "]";
	}
	
}
