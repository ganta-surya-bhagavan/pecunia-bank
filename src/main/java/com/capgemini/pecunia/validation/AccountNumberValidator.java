package com.capgemini.pecunia.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements 
ConstraintValidator<AccountNumber, Long> {

 

  @Override
  public boolean isValid(Long number,
    ConstraintValidatorContext cxt) {
      return  number.toString().length()==10;
  }

}