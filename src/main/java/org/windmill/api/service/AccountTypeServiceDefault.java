package org.windmill.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windmill.api.data.model.AccountType;
import org.windmill.api.data.repository.AccountTypeRepository;

@Service
public class AccountTypeServiceDefault implements AccountTypeService{
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;

	@Override
	public AccountType create(AccountType accountType) {
		return accountTypeRepository.save(accountType);
	}

	@Override
	public AccountType update(Long id, AccountType accountType) {
		if(!id.equals(accountType.getId())) {
			throw new RuntimeException("account type id must match");
		}
		return accountTypeRepository.save(accountType);
	}

	@Override
	public List<AccountType> list() {
		return accountTypeRepository.findAll();
	}
}
