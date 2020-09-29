package com.capgemini.pecunia;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.LoanTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
import com.capgemini.pecunia.exception.AccountNotFoundException;
import com.capgemini.pecunia.exception.InSufficientBalanceException;
import com.capgemini.pecunia.service.TranscationServiceImpl;

@SpringBootTest
class PecuniaBankApplicationTests {

	@Autowired
	TranscationServiceImpl transcationServiceImpl;
	
	@Test
	public void testCreditBySlip() throws AccountNotFoundException {
		SlipTranscationForm slipTranscationForm = new SlipTranscationForm(1000000001,1225.0,123456);
		assertTrue(transcationServiceImpl.creditBySlip(slipTranscationForm));
		
	}
	@Test
	public void testDebitBySlip() throws AccountNotFoundException, InSufficientBalanceException {
		SlipTranscationForm slipTranscationForm = new SlipTranscationForm(1000000001,225.0,123456);
		assertTrue(transcationServiceImpl.debitBySlip(slipTranscationForm));
		
	}
	@Test
	public void testDebitByCheque() throws InSufficientBalanceException, AccountNotFoundException {
		ChequeTranscationForm chequeTranscationForm = new ChequeTranscationForm(1000000001,100.50,123456,"CIUB000582",LocalDate.now());
		assertTrue(transcationServiceImpl.debitByCheque(chequeTranscationForm));
		
	}
	@Test
	public void testCreditByCheque() throws AccountNotFoundException, InSufficientBalanceException {
		ChequeCreditTranscationForm chequeCreditTranscationForm = new ChequeCreditTranscationForm(1000000001,1000,123456,"CIUB000582",LocalDate.now(),1000000002);
		assertTrue(transcationServiceImpl.creditByCheque(chequeCreditTranscationForm));
		
	}
	
	@Test
	public void testCreditByLoan() throws AccountNotFoundException {
		LoanTranscationForm chequeCreditTranscationForm = new LoanTranscationForm(125697,1000000001,1000.0);
		assertTrue(transcationServiceImpl.creditByLoan(chequeCreditTranscationForm));
		
	}
	
	@Test
	public void testAccountNotFoundException() throws AccountNotFoundException {
		LoanTranscationForm loanTranscationForm = new LoanTranscationForm(125697,1000000010,1000.0);
		assertThrows(AccountNotFoundException.class,()->transcationServiceImpl.creditByLoan(loanTranscationForm));
	}
	
	@Test
	public void testInsufficientBalanceException() throws AccountNotFoundException,InSufficientBalanceException {
		SlipTranscationForm slipTranscationForm = new SlipTranscationForm(1000000003,225.0,123456);
		assertThrows(InSufficientBalanceException.class,()->transcationServiceImpl.debitBySlip(slipTranscationForm));
	}
}
