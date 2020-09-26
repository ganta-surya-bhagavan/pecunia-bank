package com.capgemini.pecunia.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.capgemini.pecunia.util.TranscationStatus;
import com.capgemini.pecunia.util.TranscationType;

@Entity
@Table(name="pecunia_bank_transaction")
@DynamicInsert
@DynamicUpdate
@Inheritance(strategy=InheritanceType.JOINED)
public class Transcation {
	@Id
	@Column(name="transaction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	/*@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="account_id" , referencedColumnName = "account_id")*/
	@Column(name="account_id")
	private long accountNo;
	@Column(name="transaction_type")
	private String transcationType;
	@Column(name="transaction_amount")
	private double transcationAmount;
	@Column(name="balance")
	private double balance;
	@Column(name="transaction_date")
	private LocalDate transcationDate;
	@Column(name="transaction_status")
	private String transcationStatus;
	
	public Transcation() {
		super();
	}
	
	public Transcation(long accountNo, String transcationType, double transcationAmount,double balance,
			LocalDate transcationDate, String transcationStatus) {
		super();
		this.accountNo = accountNo;
		this.transcationType = transcationType;
		this.transcationAmount = transcationAmount;
		this.transcationDate = transcationDate;
		this.transcationStatus = transcationStatus;
		this.balance=balance;
	}
	
	public Transcation(Long transactionId, long accountNo, String transcationType, double transcationAmount,
			double balance, LocalDate transcationDate, String transcationStatus) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.transcationType = transcationType;
		this.transcationAmount = transcationAmount;
		this.balance = balance;
		this.transcationDate = transcationDate;
		this.transcationStatus = transcationStatus;
	}

	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long account) {
		this.accountNo = account;
	}
	public String getTranscationType() {
		return transcationType;
	}
	public void setTranscationType(String transcationType) {
		this.transcationType = transcationType;
	}
	public double getTranscationAmount() {
		return transcationAmount;
	}
	public void setTranscationAmount(double transcationAmount) {
		this.transcationAmount = transcationAmount;
	}
	public LocalDate getTranscationDate() {
		return transcationDate;
	}
	public void setTranscationDate(LocalDate transcationDate) {
		this.transcationDate = transcationDate;
	}
	public String getTranscationStatus() {
		return transcationStatus;
	}
	public void setTranscationStatus(String transcationStatus) {
		this.transcationStatus = transcationStatus;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transcation [transcationId=" + transactionId + ", accountNo=" + accountNo + ", transcationType="
				+ transcationType + ", transcationAmount=" + transcationAmount + ", balance=" + balance
				+ ", transcationDate=" + transcationDate + ", transcationStatus=" + transcationStatus + "]";
	}

	
	
	
}
