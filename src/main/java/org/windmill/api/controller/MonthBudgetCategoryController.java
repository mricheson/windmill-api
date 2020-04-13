package org.windmill.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windmill.api.data.model.MonthBudgetCategory;
import org.windmill.api.service.MonthBudgetCategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@Tag(name = "Month Budgets")
@RequestMapping("/api/budgets/{year}/{month}/categories")
@Log
public class MonthBudgetCategoryController {

	@Autowired
	private MonthBudgetCategoryService monthBudgetCategoryService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MonthBudgetCategory> list(@PathVariable("year") int year, @PathVariable("month") int month) {
		try {
			return monthBudgetCategoryService.list(month, year);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
