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
import org.windmill.api.data.model.SavingsEntry;
import org.windmill.api.service.SavingsEntryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@Tag(name = "Transactions")
@RequestMapping("/api/transactions/savings/")
@Log
public class SavingsEntryController {

	@Autowired
	private SavingsEntryService savingsEntryService;

	@GetMapping(produces = "application/json")
	public List<SavingsEntry> list() {
		try {
			return savingsEntryService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
	public SavingsEntry update(@PathVariable("id") Long id, @RequestBody SavingsEntry savingsEntry) {
		try {
			return savingsEntryService.update(id, savingsEntry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public SavingsEntry create(@RequestBody SavingsEntry savingsEntry) {
		try {
			return savingsEntryService.create(savingsEntry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
