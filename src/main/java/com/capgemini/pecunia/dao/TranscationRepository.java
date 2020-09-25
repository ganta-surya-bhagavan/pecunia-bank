package com.capgemini.pecunia.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Transcation;

@Repository
public interface TranscationRepository extends CrudRepository<Transcation, Long> {

}
