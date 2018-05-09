package com.windmill.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.windmill.api.model.AccountType;

@RepositoryRestController
public interface AccountTypeRepository extends JpaRepository<AccountType, Long>{

}
