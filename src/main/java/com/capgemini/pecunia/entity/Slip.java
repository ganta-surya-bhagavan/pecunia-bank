package com.capgemini.pecunia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="pecunia_bank_slip")
@PrimaryKeyJoinColumn(name="transaction_id")  
public class Slip extends Transcation {
	@Column(name = "slip_id")
	private long slipId;

	public Slip() {
		super();
	}

	public Slip(long transcationId,long accountNo, String transcationType, double transcationAmount,
			double balance, LocalDate transcationDate, String transcationStatus,long slipId) {
		super(transcationId,accountNo, transcationType, transcationAmount, balance, transcationDate, transcationStatus);
		this.slipId=slipId;
	}

	public long getSlipId() {
		return slipId;
	}

	public void setSlipId(long slipId) {
		this.slipId = slipId;
	}

	@Override
	public String toString() {
		return "Slip [slipId=" + slipId + ", getTranscationId()=" + getTransactionId() + ", getAccountNo()="
				+ getAccountNo() + ", getTranscationType()=" + getTranscationType() + ", getTranscationAmount()="
				+ getTranscationAmount() + ", getTranscationDate()=" + getTranscationDate()
				+ ", getTranscationStatus()=" + getTranscationStatus() + ", getBalance()=" + getBalance() + "]";
	}
	
	
	
}
