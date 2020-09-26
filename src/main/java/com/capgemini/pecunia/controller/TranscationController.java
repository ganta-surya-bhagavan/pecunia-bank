package com.capgemini.pecunia.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.capgemini.pecunia.service.TranscationService;

@RestController
public class TranscationController {
	@Autowired
	TranscationService transcationService;
	@PostMapping(
            value="/creditBySlip",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean creditBySlip(@RequestBody SlipTranscationForm  slipTranscationForm) {
		 return transcationService.creditBySlip(slipTranscationForm);
	}
	@PostMapping(
            value="/debitBySlip",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean debitBySlip(@RequestBody SlipTranscationForm  slipTranscationForm) {
		 return transcationService.debitBySlip(slipTranscationForm);
	}
	@PostMapping(
            value="/creditByCheque",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean creditByCheque(@RequestBody ChequeCreditTranscationForm  chequeCreditTranscationForm) {
		 return transcationService.creditByCheque(chequeCreditTranscationForm);
	}
	@PostMapping(
            value="/debitByCheque",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean debitByCheque(@RequestBody ChequeTranscationForm  chequeTranscationForm) {
		 return transcationService.debitByCheque(chequeTranscationForm);
	}
	@PostMapping(
            value="/creditByLoan",
            produces = "application/json",
            headers = "Accept=application/json"
	  )
	public boolean creditByLoan(@RequestBody LoanTranscationForm  loanTranscationForm) {
		 return transcationService.creditByLoan(loanTranscationForm);
	}
	@GetMapping(
            value= "/transactionList/{accountNo}",
            headers = "Accept=application/json",
            produces = "application/json"
    )	
	public List<Transcation> getApplicantsByProgramName(@PathVariable("accountNo") String accountNo){
    
	return transcationService.getAllTranscations(Long.parseLong(accountNo));
    }
}
