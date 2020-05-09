package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.Transaction;

public interface TransactionService {

	List<Transaction> list();

	List<Transaction> list(int month, int year);

	Transaction get(Long id);

	Transaction create(Transaction transaction);

	Transaction update(Long id, Transaction transaction);

	Transaction split(Long id, List<Transaction> transactions);

	List<Transaction> getChildren(Long id);

}
