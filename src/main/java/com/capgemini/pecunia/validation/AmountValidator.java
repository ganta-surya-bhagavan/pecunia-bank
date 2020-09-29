package com.capgemini.pecunia.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AmountValidator implements 
ConstraintValidator<Amount, Double> {

  
  @Override
  public boolean isValid(Double amount,
    ConstraintValidatorContext cxt) {
      return  (amount > 100) && (amount < 100000);
  }

}