package com.windmill.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.windmill.api.model.Institution; 

public interface InstitutionRepository extends JpaRepository<Institution, Long>{

}
