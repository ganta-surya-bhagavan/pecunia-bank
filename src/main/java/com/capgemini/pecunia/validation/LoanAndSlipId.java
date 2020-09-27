package com.capgemini.pecunia.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = LoanAndSlipIdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LoanAndSlipId {
    String message() default "loan or slip id should be of 6 digits";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}