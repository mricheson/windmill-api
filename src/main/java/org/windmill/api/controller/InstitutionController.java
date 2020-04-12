package org.windmill.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windmill.api.data.model.Institution;
import org.windmill.api.service.InstitutionService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/institutions/")
@Tag(name = "Institutions")
@Log
public class InstitutionController {

	@Autowired
	private InstitutionService institutionService;

	@GetMapping(produces = "application/json")
	public List<Institution> list() {
		try {
			return institutionService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
	public Institution update(@PathVariable("id") Long id, @RequestBody Institution institution) {
		try {
			return institutionService.update(id, institution);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Institution create(@RequestBody Institution institution) {
		try {
			return institutionService.create(institution);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
