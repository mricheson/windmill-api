package com.windmill.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.windmill.api.model.Account; 

@RepositoryRestController
public interface AccountRepository extends JpaRepository<Account, Long>{

}
