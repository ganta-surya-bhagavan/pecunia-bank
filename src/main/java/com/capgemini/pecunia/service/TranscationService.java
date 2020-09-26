package com.capgemini.pecunia.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.LoanTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
import com.capgemini.pecunia.entity.Transcation;

public interface TranscationService {
	public boolean creditByCheque(ChequeCreditTranscationForm chequeCreditTranscationForm);
	public boolean creditBySlip(SlipTranscationForm slipTranscationForm);
	public boolean debitByCheque(ChequeTranscationForm chequeTranscationForm);
	public boolean debitBySlip(SlipTranscationForm slipTranscationForm);
	public boolean creditByLoan(LoanTranscationForm loanTranscationForm);
	public List<Transcation> getAllTranscations(long accountNo);
}
