package com.capgemini.pecunia.dto;

import java.time.LocalDate;

import com.capgemini.pecunia.validation.AccountNumber;

public class ChequeCreditTranscationForm extends ChequeTranscationForm {
	@AccountNumber
	private long beneficiaryAccountNo;
	public ChequeCreditTranscationForm() {
		super();
	}
	public ChequeCreditTranscationForm(long payeeAccountNo, double amount, int chequeNo, String ifscCode,
			LocalDate issueDate,long beneficiaryAccountNo) {
		super(payeeAccountNo, amount, chequeNo, ifscCode, issueDate);
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}
	public long getBeneficiaryAccountNo() {
		return beneficiaryAccountNo;
	}
	public void setBeneficiaryAccountNo(long beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}
	
	@Override
	public String toString() {
		return "ChequeCreditTranscationForm [beneficiaryAccountNo=" + beneficiaryAccountNo + 
				 ", getPayeeAccountNo()=" + getPayeeAccountNo() + ", getAmount()=" + getAmount() + ", getChequeNo()="
				+ getChequeNo() + ", getIFSCcode()=" + getIfscCode() + ", getIssueDate()=" + getIssueDate() + "]";
	}
	
	
	
	
}
