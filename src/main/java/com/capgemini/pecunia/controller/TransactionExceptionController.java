package com.capgemini.pecunia.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.pecunia.dto.ExceptionResponse;
import com.capgemini.pecunia.exception.AccountNotFoundException;
import com.capgemini.pecunia.exception.InSufficientBalanceException;

@ControllerAdvice
@RestController
public class TransactionExceptionController extends ResponseEntityExceptionHandler  {
	
	  @ExceptionHandler(Exception.class)
	  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
	  @ExceptionHandler(AccountNotFoundException.class)
	  public final ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(InSufficientBalanceException.class)
	  public final ResponseEntity<Object> handleInSufficientBalanceException(InSufficientBalanceException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	  }
	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	      ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
	        ex.getBindingResult().toString());
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	  } 
}
