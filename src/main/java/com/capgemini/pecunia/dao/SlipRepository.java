package com.capgemini.pecunia.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Slip;

@Repository
public interface SlipRepository extends CrudRepository<Slip, Long> {

}
