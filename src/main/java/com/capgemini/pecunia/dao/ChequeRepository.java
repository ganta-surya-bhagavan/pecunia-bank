package com.capgemini.pecunia.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Cheque;

@Repository
public interface ChequeRepository extends CrudRepository<Cheque, Long> {

}
