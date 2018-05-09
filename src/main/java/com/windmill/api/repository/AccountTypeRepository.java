package com.windmill.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.windmill.api.model.AccountType;
 
public interface AccountTypeRepository extends JpaRepository<AccountType, Long>{

}
