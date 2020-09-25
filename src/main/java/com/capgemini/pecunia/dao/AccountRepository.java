package com.capgemini.pecunia.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.pecunia.entity.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

}
