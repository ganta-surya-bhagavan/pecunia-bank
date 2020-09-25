package com.capgemini.pecunia.dto;

import java.time.LocalDate;

public class ChequeTranscationForm {
	private long payeeAccountNo;
	private int amount;
	private int chequeNo;
	private String IFSCcode;
	private LocalDate issueDate;
	public ChequeTranscationForm() {
		super();
	}
	public ChequeTranscationForm(long payeeAccountNo, int amount, int chequeNo, String iFSCcode,
			LocalDate issueDate) {
		super();
		this.payeeAccountNo = payeeAccountNo;
		this.amount = amount;
		this.chequeNo = chequeNo;
		IFSCcode = iFSCcode;
		this.issueDate = issueDate;
	}
	public long getPayeeAccountNo() {
		return payeeAccountNo;
	}
	public void setPayeeAccountNo(long payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
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
				+ chequeNo + ", IFSCcode=" + IFSCcode + ", issueDate=" + issueDate + "]";
	}
	
}
