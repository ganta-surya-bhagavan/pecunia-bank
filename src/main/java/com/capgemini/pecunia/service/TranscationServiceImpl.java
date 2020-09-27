package com.capgemini.pecunia.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.pecunia.dao.AccountRepository;
import com.capgemini.pecunia.dao.ChequeRepository;
import com.capgemini.pecunia.dao.LoanRepository;
import com.capgemini.pecunia.dao.SlipRepository;
import com.capgemini.pecunia.dao.TranscationRepository;
import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.LoanTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
import com.capgemini.pecunia.entity.AccountEntity;
import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.Loan;
import com.capgemini.pecunia.entity.Slip;
import com.capgemini.pecunia.entity.Transcation;
import com.capgemini.pecunia.exception.AccountNotFoundException;
import com.capgemini.pecunia.exception.InSufficientBalanceException;
import com.capgemini.pecunia.util.ExceptionMessage;
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
	@Autowired
	private LoanRepository loanRepository;
	
	
	
	
	@Override
	@Transactional
	public boolean creditByCheque(ChequeCreditTranscationForm chequeCreditTranscationForm) throws AccountNotFoundException, InSufficientBalanceException  {
		AccountEntity account=accountRepository.findById(chequeCreditTranscationForm.getPayeeAccountNo()).get();
		AccountEntity beneficiary=accountRepository.findById(chequeCreditTranscationForm.getBeneficiaryAccountNo()).get();
		if(account==null ) {
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		if(beneficiary==null) {
			throw new AccountNotFoundException(ExceptionMessage.BENIFICIARY_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()-chequeCreditTranscationForm.getAmount();
		if(balance<0) {
			throw new InSufficientBalanceException(ExceptionMessage.INSUFFICIENT_BALANCE.toString());
		}
		account.setAmount(balance);
		accountRepository.save(account);
		beneficiary.setAmount(beneficiary.getAmount()+chequeCreditTranscationForm.getAmount());
		accountRepository.save(beneficiary);
		chequeRepository.save(new Cheque(11111L,chequeCreditTranscationForm.getPayeeAccountNo(), TranscationType.DebitByCheque.toString(),chequeCreditTranscationForm.getAmount(),balance,
				LocalDate.now(), TranscationStatus.Sucess.toString(),chequeCreditTranscationForm.getChequeNo(),chequeCreditTranscationForm.getIFSCcode(),chequeCreditTranscationForm.getIssueDate(),chequeCreditTranscationForm.getBeneficiaryAccountNo()));
		chequeRepository.save(new Cheque(11111L,chequeCreditTranscationForm.getBeneficiaryAccountNo(), TranscationType.CreditByCheque.toString(),chequeCreditTranscationForm.getAmount(),beneficiary.getAmount()+chequeCreditTranscationForm.getAmount(),
				LocalDate.now(), TranscationStatus.Sucess.toString(),chequeCreditTranscationForm.getChequeNo(),chequeCreditTranscationForm.getIFSCcode(),chequeCreditTranscationForm.getIssueDate(),chequeCreditTranscationForm.getPayeeAccountNo()));
		return true;
	}

	@Override
	@Transactional
	public boolean creditBySlip(SlipTranscationForm slipTranscationForm) throws AccountNotFoundException {
		AccountEntity account=accountRepository.findById(slipTranscationForm.getAccountNo()).get();
		if(account==null ) {
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()+slipTranscationForm.getAmount();
		account.setAmount(balance);
		accountRepository.save(account);
		slipRepository.save(new Slip(11111L,account.getAccountId(),TranscationType.CreditBySlip.toString(),slipTranscationForm.getAmount(),balance,
				LocalDate.now(),TranscationStatus.Sucess.toString(),slipTranscationForm.getSlipId()));
		return true;
	}

	@Override
	@Transactional
	public boolean debitByCheque(ChequeTranscationForm chequeTranscationForm) throws InSufficientBalanceException, AccountNotFoundException {
		AccountEntity account=accountRepository.findById(chequeTranscationForm.getPayeeAccountNo()).get();
		if(account==null ) {
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()-chequeTranscationForm.getAmount();
		if(balance<0) {
			throw new InSufficientBalanceException(ExceptionMessage.INSUFFICIENT_BALANCE.toString());
		}
		account.setAmount(balance);
		accountRepository.save(account);
		chequeRepository.save(new Cheque(11111L,chequeTranscationForm.getPayeeAccountNo(), TranscationType.DebitByCheque.toString(),chequeTranscationForm.getAmount(),balance,
				LocalDate.now(), TranscationStatus.Sucess.toString(),chequeTranscationForm.getChequeNo(),chequeTranscationForm.getIFSCcode(),chequeTranscationForm.getIssueDate()));
		return true;
	}

	@Override
	@Transactional
	public boolean debitBySlip(SlipTranscationForm slipTranscationForm) throws AccountNotFoundException, InSufficientBalanceException {
		AccountEntity account=accountRepository.findById(slipTranscationForm.getAccountNo()).get();
		if(account==null ) {
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()-slipTranscationForm.getAmount();
		if(balance<0) {
			throw new InSufficientBalanceException(ExceptionMessage.INSUFFICIENT_BALANCE.toString());
		}
		account.setAmount(balance);
		accountRepository.save(account);
		slipRepository.save(new Slip(11111L,account.getAccountId(),TranscationType.DebitBySlip.toString(),slipTranscationForm.getAmount(),balance,
				LocalDate.now(),TranscationStatus.Sucess.toString(),slipTranscationForm.getSlipId()));
		return true;
	}

	@Override
	@Transactional
	public boolean creditByLoan(LoanTranscationForm loanTranscationForm) throws AccountNotFoundException {
		AccountEntity account=accountRepository.findById(loanTranscationForm.getAccountNo()).get();
		if(account==null ) {
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()+loanTranscationForm.getAmount();
		account.setAmount(balance);
		accountRepository.save(account);
		loanRepository.save(new Loan(11111L,account.getAccountId(),TranscationType.CreditByLoan.toString(),loanTranscationForm.getAmount(),balance,
				LocalDate.now(),TranscationStatus.Sucess.toString(),loanTranscationForm.getLoanId()));
		return true;
	}

	@Override
	public List<Transcation> getAllTranscations(long accountNo) {
		return transcationRepository.getAllTransactionsByAccountNo(accountNo);
	}

}
