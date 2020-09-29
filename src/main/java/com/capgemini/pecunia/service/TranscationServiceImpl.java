package com.capgemini.pecunia.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.dao.ChequeRepository;
import com.capgemini.pecunia.dao.LoanRepository;
import com.capgemini.pecunia.dao.SlipRepository;
import com.capgemini.pecunia.dao.TranscationRepository;
import com.capgemini.pecunia.dto.Account;
import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.LoanTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
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
	private LoanRepository loanRepository;
	@Autowired
	private RestTemplate restTemplate;
	static final String GET_URI = "http://localhost:8080/account/accountNo/";
	static final String UPDATE_URI = "http://localhost:8080/update/";
	Logger logger = LoggerFactory.getLogger(TranscationServiceImpl.class);
	@Override
	@Transactional
	public boolean creditByCheque(ChequeCreditTranscationForm chequeCreditTranscationForm) throws AccountNotFoundException, InSufficientBalanceException  {
		Account account = restTemplate.getForObject(GET_URI+chequeCreditTranscationForm.getPayeeAccountNo(), Account.class);
		Account beneficiary = restTemplate.getForObject(GET_URI+chequeCreditTranscationForm.getBeneficiaryAccountNo(), Account.class);
		if(account==null ) {
			logger.debug("payee account doesnot exist "+chequeCreditTranscationForm.getPayeeAccountNo());
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		if(beneficiary==null) {
			logger.debug("beneficiary account doesnot exist "+chequeCreditTranscationForm.getBeneficiaryAccountNo());
			throw new AccountNotFoundException(ExceptionMessage.BENIFICIARY_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()-chequeCreditTranscationForm.getAmount();
		if(balance<0) {
			logger.debug("account has insufficient balance "+chequeCreditTranscationForm.getPayeeAccountNo());
			throw new InSufficientBalanceException(ExceptionMessage.INSUFFICIENT_BALANCE.toString());
		}
		
		chequeRepository.save(new Cheque(11111L,chequeCreditTranscationForm.getPayeeAccountNo(), TranscationType.DEBIT_BY_CHEQUE.toString(),chequeCreditTranscationForm.getAmount(),balance,
				LocalDate.now(), TranscationStatus.SUCESS.toString(),chequeCreditTranscationForm.getChequeNo(),chequeCreditTranscationForm.getIfscCode(),chequeCreditTranscationForm.getIssueDate(),chequeCreditTranscationForm.getBeneficiaryAccountNo()));
		chequeRepository.save(new Cheque(11111L,chequeCreditTranscationForm.getBeneficiaryAccountNo(), TranscationType.CREDIT_BY_CHEQUE.toString(),chequeCreditTranscationForm.getAmount(),beneficiary.getAmount()+chequeCreditTranscationForm.getAmount(),
				LocalDate.now(), TranscationStatus.SUCESS.toString(),chequeCreditTranscationForm.getChequeNo(),chequeCreditTranscationForm.getIfscCode(),chequeCreditTranscationForm.getIssueDate(),chequeCreditTranscationForm.getPayeeAccountNo()));
		logger.info("persisted cheques into database");
		account.setAmount(balance);
		restTemplate.put(UPDATE_URI,account);
		beneficiary.setAmount(beneficiary.getAmount()+chequeCreditTranscationForm.getAmount());
		restTemplate.put(UPDATE_URI,beneficiary);
		logger.info("account balance updated");
		return true;
	}

	@Override
	@Transactional
	public boolean creditBySlip(SlipTranscationForm slipTranscationForm) throws AccountNotFoundException {
		Account account = restTemplate.getForObject(GET_URI+slipTranscationForm.getAccountNo(), Account.class);
		if(account==null ) {
			logger.debug("account doesnot exist "+slipTranscationForm.getAccountNo());
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()+slipTranscationForm.getAmount();
		slipRepository.save(new Slip(11111L,slipTranscationForm.getAccountNo(),TranscationType.CREDIT_BY_SLIP.toString(),slipTranscationForm.getAmount(),balance,
				LocalDate.now(),TranscationStatus.SUCESS.toString(),slipTranscationForm.getSlipId()));
		logger.info("persisted cheque into database");
		account.setAmount(balance);
		restTemplate.put(UPDATE_URI,account);
		logger.info("account balance updated");
		return true;
	}

	@Override
	@Transactional
	public boolean debitByCheque(ChequeTranscationForm chequeTranscationForm) throws InSufficientBalanceException, AccountNotFoundException {
		Account account = restTemplate.getForObject(GET_URI+chequeTranscationForm.getPayeeAccountNo(), Account.class);
		if(account==null ) {
			logger.debug("account doesnot exist "+chequeTranscationForm.getPayeeAccountNo());
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()-chequeTranscationForm.getAmount();
		if(balance<0) {
			logger.debug("account has insufficient balance "+chequeTranscationForm.getPayeeAccountNo());
			throw new InSufficientBalanceException(ExceptionMessage.INSUFFICIENT_BALANCE.toString());
		}
		chequeRepository.save(new Cheque(11111L,chequeTranscationForm.getPayeeAccountNo(), TranscationType.DEBIT_BY_CHEQUE.toString(),chequeTranscationForm.getAmount(),balance,
				LocalDate.now(), TranscationStatus.SUCESS.toString(),chequeTranscationForm.getChequeNo(),chequeTranscationForm.getIfscCode(),chequeTranscationForm.getIssueDate()));
		logger.info("persisted cheque into database");
		account.setAmount(balance);
		restTemplate.put(UPDATE_URI,account);
		logger.info("account balance updated");
		return true;
	}

	@Override
	@Transactional
	public boolean debitBySlip(SlipTranscationForm slipTranscationForm) throws AccountNotFoundException, InSufficientBalanceException {

		Account account = restTemplate.getForObject(GET_URI+slipTranscationForm.getAccountNo(), Account.class);
		
		if(account==null ) {
			logger.debug("account doesnot exist "+slipTranscationForm.getAccountNo());
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()-slipTranscationForm.getAmount();
		if(balance<0) {
			logger.debug("account has insufficient balance "+slipTranscationForm.getAccountNo());
			throw new InSufficientBalanceException(ExceptionMessage.INSUFFICIENT_BALANCE.toString());
		}
		slipRepository.save(new Slip(11111L,slipTranscationForm.getAccountNo(),TranscationType.DEBIT_BY_SLIP.toString(),slipTranscationForm.getAmount(),balance,
				LocalDate.now(),TranscationStatus.SUCESS.toString(),slipTranscationForm.getSlipId()));
		logger.info("persisted slip into database");
		account.setAmount(balance);
		restTemplate.put(UPDATE_URI,account);
		logger.info("account balance updated");
		return true;
	}

	@Override
	@Transactional
	public boolean creditByLoan(LoanTranscationForm loanTranscationForm) throws AccountNotFoundException {
		Account account = restTemplate.getForObject(GET_URI+loanTranscationForm.getAccountNo(), Account.class);
		if(account==null ) {
			logger.debug("account doesnot exist "+loanTranscationForm.getAccountNo());
			throw new AccountNotFoundException(ExceptionMessage.PAYEE_ACCOUNT_NOT_FOUND.toString());
		}
		double balance=account.getAmount()+loanTranscationForm.getAmount();
		loanRepository.save(new Loan(11111L,loanTranscationForm.getAccountNo(),TranscationType.CREDIT_BY_LOAN.toString(),loanTranscationForm.getAmount(),balance,
				LocalDate.now(),TranscationStatus.SUCESS.toString(),loanTranscationForm.getLoanId()));
		logger.info("persisted loan into database");
		account.setAmount(balance);
		restTemplate.put(UPDATE_URI,account);
		logger.info("account balance updated");
		return true;
	}

	@Override
	public List<Transcation> getAllTranscations(long accountNo) {
		logger.info("returned the list of transactions");
		return transcationRepository.getAllTransactionsByAccountNo(accountNo);
	}

}
