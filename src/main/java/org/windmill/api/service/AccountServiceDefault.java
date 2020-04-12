package org.windmill.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windmill.api.data.model.Account;
import org.windmill.api.data.repository.AccountRepository;

@Service
public class AccountServiceDefault implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account create(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account update(Long id, Account account) {
		if (!id.equals(account.getId())) {
			throw new RuntimeException("account ids must match");
		}
		return accountRepository.save(account);
	}

	@Override
	public List<Account> list() {
		return accountRepository.findAll();
	}
}
