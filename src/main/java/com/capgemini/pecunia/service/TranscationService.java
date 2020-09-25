package com.capgemini.pecunia.service;

import com.capgemini.pecunia.dto.ChequeCreditTranscationForm;
import com.capgemini.pecunia.dto.ChequeTranscationForm;
import com.capgemini.pecunia.dto.SlipTranscationForm;

public interface TranscationService {
	public boolean cerditByCheque(ChequeCreditTranscationForm chequeCreditTranscationForm);
	public boolean creditBySlip(SlipTranscationForm slipTranscationForm);
	public boolean debitByCheque(ChequeTranscationForm chequeTranscationForm);
	public boolean debitBySlip(SlipTranscationForm slipTranscationForm);
}
