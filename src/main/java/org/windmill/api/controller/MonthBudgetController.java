package org.windmill.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windmill.api.data.model.MonthBudget;
import org.windmill.api.service.MonthBudgetService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@Tag(name = "Month Budgets")
@RequestMapping("/api/budgets/")
@Log
public class MonthBudgetController {

	@Autowired
	private MonthBudgetService monthBudgetService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MonthBudget> list() {
		try {
			return monthBudgetService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MonthBudget get(@PathVariable("year") int year, @PathVariable("month") int month) {
		try {
			return monthBudgetService.get(month, year);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(value = "{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MonthBudget create(@PathVariable("year") int year, @PathVariable("month") int month) {
		try {
			return monthBudgetService.create(month, year);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(value = "{year}/{month}/reconcile", produces = MediaType.APPLICATION_JSON_VALUE)
	public MonthBudget reconcile(@PathVariable("year") int year, @PathVariable("month") int month) {
		try {
			return monthBudgetService.reconcile(month, year);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
