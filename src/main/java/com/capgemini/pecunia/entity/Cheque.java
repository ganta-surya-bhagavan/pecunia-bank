package com.capgemini.pecunia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.capgemini.pecunia.util.TranscationStatus;
import com.capgemini.pecunia.util.TranscationType;

@Entity
@Table(name="pecunia_bank_cheque")
@PrimaryKeyJoinColumn(name="transactionId")  
public class Cheque extends Transcation {
	@Column(name = "cheque_id")
	private int chequeId;
	@Column(name = "ifsc_code")
	private String IFSCcode;
	@Column(name = "cheque_issue_date")
	private LocalDate issueDate;
	@Column(name = "benificiary_account_number")
	private long beneficiaryAccountNumber;
	public Cheque() {
		super();
	}
	public Cheque(long transcationId,long accountNo, String transcationType, double transcationAmount,double balance,
			LocalDate transcationDate, String transcationStatus,int chequeId, String iFSCcode, LocalDate issueDate, long beneficiaryAccountNumber) {
		super(transcationId,accountNo, transcationType, transcationAmount,balance, transcationDate, transcationStatus);
		this.chequeId = chequeId;
		IFSCcode = iFSCcode;
		this.issueDate = issueDate;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public Cheque(long transcationId,long accountNo, String transcationType, double transcationAmount,double balance,
			LocalDate transcationDate, String transcationStatus,int chequeId, String iFSCcode, LocalDate issueDate) {
		super(transcationId,accountNo, transcationType, transcationAmount,balance, transcationDate, transcationStatus);
		this.chequeId = chequeId;
		IFSCcode = iFSCcode;
		this.issueDate = issueDate;
	}
	public int getChequeId() {
		return chequeId;
	}
	public void setChequeId(int chequeId) {
		this.chequeId = chequeId;
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
	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", IFSCcode=" + IFSCcode + ", issueDate=" + issueDate
				+ ", beneficiaryAccountNumber=" + beneficiaryAccountNumber + ", getTranscationId()="
				+ getTransactionId() + ", getAccountNo()=" + getAccountNo() + ", getTranscationType()="
				+ getTranscationType() + ", getTranscationAmount()=" + getTranscationAmount()
				+"balnce" +getBalance()+", getTranscationDate()=" + getTranscationDate() + ", getTranscationStatus()="
				+ getTranscationStatus() + "]";
	}
	
	
	
}
