package com.capgemini.pecunia.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.LoanTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
import com.capgemini.pecunia.entity.Transcation;
import com.capgemini.pecunia.exception.AccountNotFoundException;
import com.capgemini.pecunia.exception.InSufficientBalanceException;

public interface TranscationService {
	public boolean creditByCheque(ChequeCreditTranscationForm chequeCreditTranscationForm) throws AccountNotFoundException, InSufficientBalanceException;
	public boolean creditBySlip(SlipTranscationForm slipTranscationForm) throws AccountNotFoundException;
	public boolean debitByCheque(ChequeTranscationForm chequeTranscationForm) throws InSufficientBalanceException, AccountNotFoundException;
	public boolean debitBySlip(SlipTranscationForm slipTranscationForm) throws AccountNotFoundException, InSufficientBalanceException;
	public boolean creditByLoan(LoanTranscationForm loanTranscationForm) throws AccountNotFoundException;
	public List<Transcation> getAllTranscations(long accountNo);
}
