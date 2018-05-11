package com.windmill.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.windmill.api.model.Institution;

@CrossOrigin
@RepositoryRestController
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
