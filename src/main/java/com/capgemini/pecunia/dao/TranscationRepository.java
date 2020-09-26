package com.capgemini.pecunia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Transcation;

@Repository
public interface TranscationRepository extends CrudRepository<Transcation, Long> {
	
	@Query("select transcation from Transcation transcation where transcation.accountNo=:accountNo")
	public List<Transcation> getAllTransactionsByAccountNo(@Param("accountNo") long accountNo);
}
