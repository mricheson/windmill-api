package com.windmill.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.windmill.api.model.AccountType;
@CrossOrigin
@RepositoryRestController
public interface AccountTypeRepository extends JpaRepository<AccountType, Long>{

}
