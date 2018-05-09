package com.windmill.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.windmill.api.model.Account; 

public interface AccountRepository extends JpaRepository<Account, Long>{

}
