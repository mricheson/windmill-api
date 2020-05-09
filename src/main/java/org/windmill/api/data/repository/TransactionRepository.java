package org.windmill.api.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.windmill.api.data.model.MonthBudget;
import org.windmill.api.data.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByMonthBudget(MonthBudget monthBudget);

	List<Transaction> findByMonthBudget_Date(LocalDate buildDateFromParts);

	List<Transaction> findByParent_Id(Long id);
}
