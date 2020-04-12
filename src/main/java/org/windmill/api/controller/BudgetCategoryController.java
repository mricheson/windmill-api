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
import org.windmill.api.data.model.BudgetCategory;
import org.windmill.api.service.BudgetCategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@Tag(name = "Budget")
@RequestMapping("/api/budget/category/")
@Log
public class BudgetCategoryController {

	@Autowired
	private BudgetCategoryService budgetCategoryService;

	@GetMapping(produces = "application/json")
	public List<BudgetCategory> list() {
		try {
			return budgetCategoryService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
	public BudgetCategory update(@PathVariable("id") Long id, @RequestBody BudgetCategory budgetCategory) {
		try {
			return budgetCategoryService.update(id, budgetCategory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public BudgetCategory create(@RequestBody BudgetCategory budgetCategory) {
		try {
			return budgetCategoryService.create(budgetCategory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
