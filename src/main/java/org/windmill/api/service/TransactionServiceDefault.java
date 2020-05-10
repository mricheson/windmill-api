package org.windmill.api.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.windmill.api.data.model.Transaction;
import org.windmill.api.data.repository.MonthBudgetRepository;
import org.windmill.api.data.repository.TransactionRepository;

@Service
public class TransactionServiceDefault implements TransactionService {

	@Autowired
	private TransactionRepository transtionRepository;

	@Autowired
	private MonthBudgetRepository monthBudgetRepository;

	@Override
	public List<Transaction> list() {
		return transtionRepository.findByMonthBudget(null).stream()
				.sorted(Comparator.nullsLast((e1, e2) -> e2.getTransactionDate().compareTo(e1.getTransactionDate())))
				.collect(Collectors.toList());
	}

	@Override
	public List<Transaction> list(int month, int year) {
		return transtionRepository.findByMonthBudget_Date(buildDateFromParts(month, year));
	}

	@Override
	public Transaction get(Long id) {
		return transtionRepository.getOne(id);
	}

	@Override
	public Transaction create(Transaction transaction) {
		return transtionRepository.save(transaction);
	}

	@Override
	public Transaction update(Long id, Transaction transaction) {
		if (!id.equals(transaction.getId())) {
			throw new RuntimeException("institution ids must match");
		}
		return transtionRepository.save(transaction);
	}

	@Override
	@Transactional
	public Transaction split(Long id, List<Transaction> transactions) {
		Transaction parent = get(id);

		if (parent.isSplit()) {
			throw new RuntimeException("transaction already split");
		}

		if (transactions.size() == 0) {
			throw new RuntimeException("no splits provided");
		}

		BigDecimal sum = transactions.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		if (!sum.equals(parent.getAmount())) {
			throw new RuntimeException("split amounts don't sum to parent");
		}

		transactions.forEach(transtionRepository::save);
		parent.setSplit(true);
		return transtionRepository.save(parent);

	}

	LocalDate buildDateFromParts(int month, int year) {
		return LocalDate.of(year, month, 1);
	}

	@Override
	public List<Transaction> getChildren(Long id) {
		return transtionRepository.findByParent_Id(id);
	}
}
