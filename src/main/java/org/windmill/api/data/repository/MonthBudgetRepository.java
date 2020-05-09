package org.windmill.api.data.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.windmill.api.data.model.MonthBudget;

@Repository
public interface MonthBudgetRepository extends JpaRepository<MonthBudget, Long> {
	MonthBudget getByDate(LocalDate date);
}
