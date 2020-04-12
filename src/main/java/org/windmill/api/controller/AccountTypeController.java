package org.windmill.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windmill.api.data.model.AccountType;
import org.windmill.api.service.AccountTypeService;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/accounttypes")
@Log
public class AccountTypeController {
	
	@Autowired
	private AccountTypeService accountTypeService;
	
	@GetMapping("/")
	public List<AccountType> list(){
		try {
			return accountTypeService.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/{id}")
	public AccountType update(@PathVariable("id") Long id, AccountType accountType){
		try {
			return accountTypeService.update(id, accountType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping
	public AccountType create(AccountType accountType){
		try {
			return accountTypeService.create(accountType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
