package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.Account;

public interface AccountService {
	Account create(Account account);

	Account update(Long id, Account account);

	List<Account> list();
}
