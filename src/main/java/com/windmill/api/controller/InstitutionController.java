package com.windmill.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.windmill.api.model.Institution;
import com.windmill.api.repository.InstitutionRepository;

@RestController
@RequestMapping("/institutions")
public class InstitutionController {
	
	@Autowired
	private InstitutionRepository institutionRepository;
	
	@GetMapping
	public List<Institution> getAll()
	{
		List<Institution> institutions =  institutionRepository.findAll();
		institutions.sort((i1,i2) -> i1.getName().compareToIgnoreCase(i2.getName()));
		return institutions;
	}
	
	@GetMapping("/{id}")
	public Institution getInstitution(@PathVariable("id")long id )
	{
		return institutionRepository.findById(id).orElse(null);
	}
	
	@PostMapping(value="/new")
	public Institution putInstitution(@RequestBody Institution institution)
	{
		System.out.println("NEW institution: " + institution.getName());
		return institutionRepository.save(institution);
	}

}
