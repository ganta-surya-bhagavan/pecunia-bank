package com.capgemini.pecunia.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.AccountRepository;
import com.capgemini.pecunia.dao.ChequeRepository;
import com.capgemini.pecunia.dao.SlipRepository;
import com.capgemini.pecunia.dao.TranscationRepository;
import com.capgemini.pecunia.dto.Account;
import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
import com.capgemini.pecunia.entity.AccountEntity;
import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.Slip;
import com.capgemini.pecunia.util.TranscationStatus;
import com.capgemini.pecunia.util.TranscationType;

@Service
public class TranscationServiceImpl implements TranscationService {
	@Autowired
	private ChequeRepository chequeRepository;
	@Autowired 
	private TranscationRepository transcationRepository;
	@Autowired
	private SlipRepository slipRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public boolean cerditByCheque(ChequeCreditTranscationForm chequeCreditTranscationForm) {
		AccountEntity account=accountRepository.findById(chequeCreditTranscationForm.getPayeeAccountNo()).get();
		AccountEntity beneficiary=accountRepository.findById(chequeCreditTranscationForm.getBeneficiaryAccountNo()).get();
		int balance=account.getAmount()-chequeCreditTranscationForm.getAmount();
		account.setAmount(balance);
		accountRepository.save(account);
		beneficiary.setAmount(beneficiary.getAmount()+chequeCreditTranscationForm.getAmount());
		accountRepository.save(beneficiary);
		chequeRepository.save(new Cheque(chequeCreditTranscationForm.getPayeeAccountNo(), TranscationType.Debit,chequeCreditTranscationForm.getAmount(),balance,
				LocalDate.now(), TranscationStatus.Sucess,chequeCreditTranscationForm.getChequeNo(),chequeCreditTranscationForm.getIFSCcode(),chequeCreditTranscationForm.getIssueDate(),chequeCreditTranscationForm.getBeneficiaryAccountNo()));
		chequeRepository.save(new Cheque(chequeCreditTranscationForm.getBeneficiaryAccountNo(), TranscationType.Credit,chequeCreditTranscationForm.getAmount(),beneficiary.getAmount()+chequeCreditTranscationForm.getAmount(),
				LocalDate.now(), TranscationStatus.Sucess,chequeCreditTranscationForm.getChequeNo(),chequeCreditTranscationForm.getIFSCcode(),chequeCreditTranscationForm.getIssueDate(),chequeCreditTranscationForm.getPayeeAccountNo()));
		return true;
	}

	@Override
	public boolean creditBySlip(SlipTranscationForm slipTranscationForm) {
		AccountEntity account=accountRepository.findById(slipTranscationForm.getAccountNo()).get();
		int balance=account.getAmount()+slipTranscationForm.getAmount();
		account.setAmount(balance);
		accountRepository.save(account);
		slipRepository.save(new Slip(account.getAccountId(),TranscationType.Credit,slipTranscationForm.getAmount(),balance,
				LocalDate.now(),TranscationStatus.Sucess,slipTranscationForm.getSlipId()));
		return true;
	}

	@Override
	public boolean debitByCheque(ChequeTranscationForm chequeTranscationForm) {
		AccountEntity account=accountRepository.findById(chequeTranscationForm.getPayeeAccountNo()).get();
		int balance=account.getAmount()-chequeTranscationForm.getAmount();
		account.setAmount(balance);
		accountRepository.save(account);
		chequeRepository.save(new Cheque(chequeTranscationForm.getPayeeAccountNo(), TranscationType.Debit,chequeTranscationForm.getAmount(),balance,
				LocalDate.now(), TranscationStatus.Sucess,chequeTranscationForm.getChequeNo(),chequeTranscationForm.getIFSCcode(),chequeTranscationForm.getIssueDate()));
		return true;
	}

	@Override
	public boolean debitBySlip(SlipTranscationForm slipTranscationForm) {
		AccountEntity account=accountRepository.findById(slipTranscationForm.getAccountNo()).get();
		int balance=account.getAmount()-slipTranscationForm.getAmount();
		account.setAmount(balance);
		accountRepository.save(account);
		slipRepository.save(new Slip(account.getAccountId(),TranscationType.Credit,slipTranscationForm.getAmount(),balance,
				LocalDate.now(),TranscationStatus.Sucess,slipTranscationForm.getSlipId()));
		return true;
	}

}
