package com.capgemini.pecunia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="pecunia_bank_loan")
@PrimaryKeyJoinColumn(name="transaction_id") 
public class Loan extends Transcation {
	@Column(name="loan_id",unique=true)
	private long loanId;
	public Loan() {
		super();
	}
	public Loan(long transcationId,long accountNo, String transcationType, double transcationAmount,
			double balance, LocalDate transcationDate,long loanId) {
		super(transcationId,accountNo, transcationType, transcationAmount, balance, transcationDate);
		this.loanId=loanId;
	}
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", getTransactionId()=" + getTransactionId() + ", getAccountNo()="
				+ getAccountNo() + ", getTranscationType()=" + getTranscationType() + ", getTranscationAmount()="
				+ getTranscationAmount() + ", getTranscationDate()=" + getTranscationDate()
				+ ", getBalance()=" + getBalance() + "]";
	}
	
}
