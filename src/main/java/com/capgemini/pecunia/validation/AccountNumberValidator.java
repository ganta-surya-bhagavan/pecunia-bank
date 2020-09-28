package com.capgemini.pecunia.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements 
ConstraintValidator<AccountNumber, Long> {

  @Override
  public void initialize(AccountNumber accountNumber) {
  }

  @Override
  public boolean isValid(Long number,
    ConstraintValidatorContext cxt) {
      return  (number >= 100000000) && (number < 999999999);
  }

}