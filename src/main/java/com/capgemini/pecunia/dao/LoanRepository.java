package com.capgemini.pecunia.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.pecunia.entity.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long> {

}
