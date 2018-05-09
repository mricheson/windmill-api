package com.windmill.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.windmill.api.model.Institution; 

@RepositoryRestController
public interface InstitutionRepository extends JpaRepository<Institution, Long>{

}
