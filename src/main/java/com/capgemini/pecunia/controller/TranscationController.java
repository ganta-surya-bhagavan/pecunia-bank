package com.capgemini.pecunia.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.LoanTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
import com.capgemini.pecunia.entity.Transcation;
import com.capgemini.pecunia.exception.AccountNotFoundException;
import com.capgemini.pecunia.exception.InSufficientBalanceException;
import com.capgemini.pecunia.service.TranscationService;

@RestController
public class TranscationController {
	@Autowired
	TranscationService transcationService;
	Logger logger = LoggerFactory.getLogger(TranscationController.class);
	@PostMapping(
            value="/creditBySlip",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean creditBySlip(@Valid @RequestBody SlipTranscationForm  slipTranscationForm) throws AccountNotFoundException {
		 logger.info("In creditBySlip method with account number "+slipTranscationForm.getAccountNo());
		 return transcationService.creditBySlip(slipTranscationForm);
	}
	@PostMapping(
            value="/debitBySlip",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean debitBySlip(@Valid @RequestBody SlipTranscationForm  slipTranscationForm) throws AccountNotFoundException, InSufficientBalanceException {
		logger.info("In debitBySlip method with account number "+slipTranscationForm.getAccountNo()); 
		return transcationService.debitBySlip(slipTranscationForm);
	}
	@PostMapping(
            value="/creditByCheque",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean creditByCheque(@Valid @RequestBody ChequeCreditTranscationForm  chequeCreditTranscationForm) throws AccountNotFoundException, InSufficientBalanceException {
		logger.info("In creditByCheque method with payee account number "+chequeCreditTranscationForm.getPayeeAccountNo()+"and benificiary account number"+chequeCreditTranscationForm.getBeneficiaryAccountNo()); 
		return transcationService.creditByCheque(chequeCreditTranscationForm);
	}
	@PostMapping(
            value="/debitByCheque",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean debitByCheque(@Valid @RequestBody ChequeTranscationForm  chequeTranscationForm) throws InSufficientBalanceException, AccountNotFoundException {
		logger.info("In debitByCheque method with payee account number "+chequeTranscationForm.getPayeeAccountNo()); 
		return transcationService.debitByCheque(chequeTranscationForm);
	}
	@PostMapping(
            value="/creditByLoan",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean creditByLoan(@Valid @RequestBody LoanTranscationForm  loanTranscationForm) throws AccountNotFoundException {
		logger.info("In creditByLoan method with payee account number "+loanTranscationForm.getAccountNo()); 
		return transcationService.creditByLoan(loanTranscationForm);
	}
	@GetMapping(
            value= "/transactionList/{accountNo}",
            headers = "Accept=application/json",
            produces = "application/json"
    )	
	public List<Transcation> getAllTranscations(@PathVariable("accountNo") String accountNo){
		logger.info("In getAllTranscations  for payee account number "+accountNo); 
		return transcationService.getAllTranscations(Long.parseLong(accountNo));
    }
}
