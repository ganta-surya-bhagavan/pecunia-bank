package com.capgemini.pecunia.dto;

import java.time.LocalDate;

public class ChequeCreditTranscationForm extends ChequeTranscationForm {
	private long beneficiaryAccountNo;
	private String bankName;
	public ChequeCreditTranscationForm() {
		super();
	}
	public ChequeCreditTranscationForm(long payeeAccountNo, int amount, int chequeNo, String iFSCcode,
			LocalDate issueDate,long beneficiaryAccountNo, String bankName) {
		super(payeeAccountNo, amount, chequeNo, iFSCcode, issueDate);
		this.beneficiaryAccountNo = beneficiaryAccountNo;
		this.bankName = bankName;
	}
	public long getBeneficiaryAccountNo() {
		return beneficiaryAccountNo;
	}
	public void setBeneficiaryAccountNo(long beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "ChequeCreditTranscationForm [beneficiaryAccountNo=" + beneficiaryAccountNo + ", bankName=" + bankName
				+ ", getPayeeAccountNo()=" + getPayeeAccountNo() + ", getAmount()=" + getAmount() + ", getChequeNo()="
				+ getChequeNo() + ", getIFSCcode()=" + getIFSCcode() + ", getIssueDate()=" + getIssueDate() + "]";
	}
	
	
	
	
}
