package org.windmill.api.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.windmill.api.data.model.MonthBudgetCategory;

@Repository
public interface MonthBudgetCategoryRepository extends JpaRepository<MonthBudgetCategory, Long> {
	List<MonthBudgetCategory> findByMonthBudget_Date(LocalDate date);
}
