package com.capgemini.pecunia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
//import org.junit,Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.pecunia.dao.AccountRepository;
import com.capgemini.pecunia.dao.ChequeRepository;
import com.capgemini.pecunia.dao.SlipRepository;
import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.LoanTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
import com.capgemini.pecunia.entity.AccountEntity;
import com.capgemini.pecunia.exception.AccountNotFoundException;
import com.capgemini.pecunia.exception.InSufficientBalanceException;
import com.capgemini.pecunia.service.TranscationServiceImpl;

@SpringBootTest
class PecuniaBankApplicationTests {

	@Autowired
	TranscationServiceImpl transcationServiceImpl;
	
	@Autowired
	AccountRepository accountRepository; 
	
	@Autowired
	ChequeRepository chequeRepository;
	
	@Autowired
	SlipRepository slipRepository;
	
	@Test
	public void testCreditBySlip() throws AccountNotFoundException {
		SlipTranscationForm slipTranscationForm = new SlipTranscationForm(100000000,1225.0,123456);
		assertTrue(transcationServiceImpl.creditBySlip(slipTranscationForm));
		
	}
	@Test
	public void testDebitBySlip() throws AccountNotFoundException, InSufficientBalanceException {
		SlipTranscationForm slipTranscationForm = new SlipTranscationForm(100000000,225.0,123456);
		assertTrue(transcationServiceImpl.debitBySlip(slipTranscationForm));
		
	}
	@Test
	public void testDebitByCheque() throws InSufficientBalanceException, AccountNotFoundException {
		ChequeTranscationForm chequeTranscationForm = new ChequeTranscationForm(100000000,100.50,123456,"CIUB000582",LocalDate.now());
		assertTrue(transcationServiceImpl.debitByCheque(chequeTranscationForm));
		
	}
	@Test
	public void testCreditByCheque() throws AccountNotFoundException, InSufficientBalanceException {
		ChequeCreditTranscationForm chequeCreditTranscationForm = new ChequeCreditTranscationForm(100000000,1000,123456,"CIUB000582",LocalDate.now(),100000001,"CUB");
		assertTrue(transcationServiceImpl.creditByCheque(chequeCreditTranscationForm));
		
	}
	
	@Test
	public void testCreditByLoan() throws AccountNotFoundException {
		LoanTranscationForm chequeCreditTranscationForm = new LoanTranscationForm(125697,100000000,1000.0);
		assertTrue(transcationServiceImpl.creditByLoan(chequeCreditTranscationForm));
		
	}
	
	
}
