package com.capgemini.pecunia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.pecunia.dao.AccountRepository;
import com.capgemini.pecunia.dao.ChequeRepository;
import com.capgemini.pecunia.dao.SlipRepository;
import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;
import com.capgemini.pecunia.entity.AccountEntity;
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
	public void testCreditBySlip() {
		SlipTranscationForm slipTranscationForm = new SlipTranscationForm(12345,1225,100);
		assertTrue(transcationServiceImpl.creditBySlip(slipTranscationForm));
		
	}
	@Test
	public void testDebitBySlip() {
		SlipTranscationForm slipTranscationForm = new SlipTranscationForm(12345,1225,100);
		assertTrue(transcationServiceImpl.debitBySlip(slipTranscationForm));
		
	}
	@Test
	public void testDebitByCheque() {
		ChequeTranscationForm chequeTranscationForm = new ChequeTranscationForm(12345,100,178,"CIUB",LocalDate.now());
		assertTrue(transcationServiceImpl.debitByCheque(chequeTranscationForm));
		
	}
	@Test
	public void testCreditByCheque() {
		ChequeCreditTranscationForm chequeCreditTranscationForm = new ChequeCreditTranscationForm(12345,100,178,"CIUB",LocalDate.now(),12346,"CUB");
		assertTrue(transcationServiceImpl.creditByCheque(chequeCreditTranscationForm));
		
	}


}
