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
import org.windmill.api.data.model.BudgetTemplate;
import org.windmill.api.service.BudgetTemplateService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@Tag(name = "Budget")
@RequestMapping("/api/budget/tempate/")
@Log
public class BudgetTemplateController {

	@Autowired
	private BudgetTemplateService budgetTemplateService;

	@GetMapping(produces = "application/json")
	public List<BudgetTemplate> list() {
		try {
			return budgetTemplateService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
	public BudgetTemplate update(@PathVariable("id") Long id, @RequestBody BudgetTemplate budgetTemplate) {
		try {
			return budgetTemplateService.update(id, budgetTemplate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public BudgetTemplate create(@RequestBody BudgetTemplate budgetTemplate) {
		try {
			return budgetTemplateService.create(budgetTemplate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
