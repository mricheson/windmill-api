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
import org.windmill.api.data.model.Account;
import org.windmill.api.service.AccountService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/accounts/")
@Tag(name = "Accounts")
@Log
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping(produces = "application/json")
	public List<Account> list() {
		try {
			return accountService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "{id}", consumes = "application/json", produces = "application/json")
	public Account update(@PathVariable("id") Long id, @RequestBody Account account) {
		try {
			return accountService.update(id, account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Account create(@RequestBody Account account) {
		try {
			return accountService.create(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
