package com.capgemini.pecunia.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoanAndSlipIdValidator implements 
ConstraintValidator<LoanAndSlipId, Long> {

 

  @Override
  public boolean isValid(Long loanAndSlipId,
    ConstraintValidatorContext cxt) {
      return  loanAndSlipId.toString().length()==6;
  }

}