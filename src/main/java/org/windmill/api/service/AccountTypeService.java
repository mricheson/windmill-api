package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.AccountType;

public interface AccountTypeService {
	AccountType create(AccountType accountType);
	AccountType update(AccountType accountType);
	List<AccountType> list();
}
