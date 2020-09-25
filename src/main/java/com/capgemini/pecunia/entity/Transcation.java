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
	private Long transcationId;
	/*@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="account_id" , referencedColumnName = "account_id")*/
	@Column(name="account_id")
	private long accountNo;
	@Column(name="transaction_type")
	private TranscationType transcationType;
	@Column(name="transaction_amount")
	private int transcationAmount;
	@Column(name="balance")
	private int balance;
	@Column(name="transaction_date")
	private LocalDate transcationDate;
	@Column(name="transaction_status")
	private TranscationStatus transcationStatus;
	
	public Transcation() {
		super();
	}
	
	public Transcation(long accountNo, TranscationType transcationType, int transcationAmount,int balance,
			LocalDate transcationDate, TranscationStatus transcationStatus) {
		super();
		this.accountNo = accountNo;
		this.transcationType = transcationType;
		this.transcationAmount = transcationAmount;
		this.transcationDate = transcationDate;
		this.transcationStatus = transcationStatus;
		this.balance=balance;
	}

	public long getTranscationId() {
		return transcationId;
	}
	public void setTranscationId(long transcationId) {
		this.transcationId = transcationId;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public TranscationType getTranscationType() {
		return transcationType;
	}
	public void setTranscationType(TranscationType transcationType) {
		this.transcationType = transcationType;
	}
	public int getTranscationAmount() {
		return transcationAmount;
	}
	public void setTranscationAmount(int transcationAmount) {
		this.transcationAmount = transcationAmount;
	}
	public LocalDate getTranscationDate() {
		return transcationDate;
	}
	public void setTranscationDate(LocalDate transcationDate) {
		this.transcationDate = transcationDate;
	}
	public TranscationStatus getTranscationStatus() {
		return transcationStatus;
	}
	public void setTranscationStatus(TranscationStatus transcationStatus) {
		this.transcationStatus = transcationStatus;
	}
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transcation [transcationId=" + transcationId + ", accountNo=" + accountNo + ", transcationType="
				+ transcationType + ", transcationAmount=" + transcationAmount + ", balance=" + balance
				+ ", transcationDate=" + transcationDate + ", transcationStatus=" + transcationStatus + "]";
	}

	
	
	
}
