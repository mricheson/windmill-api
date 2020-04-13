package org.windmill.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windmill.api.data.model.Transaction;
import org.windmill.api.service.TransactionService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@Tag(name = "Transactions")
@RequestMapping("/api/transactions")
@Log
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> listUnlinked() {
		try {
			return transactionService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> list(@PathVariable("year") int year, @PathVariable("month") int month) {
		try {
			return transactionService.list(month, year);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction get(@PathVariable("id") Long id) {
		try {
			return transactionService.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/{id}/children", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getChildren(@PathVariable("id") Long id) {
		try {
			return transactionService.getChildren(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction create(@RequestBody Transaction transaction) {
		try {
			return transactionService.create(transaction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction update(@PathVariable("id") Long id, @RequestBody Transaction transaction) {
		try {
			return transactionService.update(id, transaction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(value = "/{id}/split", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction create(@PathVariable("id") Long id, @RequestBody List<Transaction> transactions) {
		try {
			return transactionService.split(id, transactions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
