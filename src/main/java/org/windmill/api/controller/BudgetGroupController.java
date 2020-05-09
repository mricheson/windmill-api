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
import org.windmill.api.data.model.BudgetGroup;
import org.windmill.api.service.BudgetGroupService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@Tag(name = "Budgets")
@RequestMapping("/api/budgets/groups/")
@Log
public class BudgetGroupController {

	@Autowired
	private BudgetGroupService budgetGroupService;

	@GetMapping(produces = "application/json")
	public List<BudgetGroup> list() {
		try {
			return budgetGroupService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
	public BudgetGroup update(@PathVariable("id") Long id, @RequestBody BudgetGroup budgetGroup) {
		try {
			return budgetGroupService.update(id, budgetGroup);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public BudgetGroup create(@RequestBody BudgetGroup budgetGroup) {
		try {
			return budgetGroupService.create(budgetGroup);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
