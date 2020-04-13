package org.windmill.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windmill.api.data.model.MonthBudgetCategory;
import org.windmill.api.data.repository.MonthBudgetCategoryRepository;

@Service
public class MonthBudgetCategoryServiceDefault implements MonthBudgetCategoryService {
	@Autowired
	private MonthBudgetCategoryRepository monthBudgetPlanRepository;

	@Override
	public List<MonthBudgetCategory> list(int month, int year) {
		return monthBudgetPlanRepository.findByMonthBudget_Date(buildDateFromParts(month, year));
	}

	LocalDate buildDateFromParts(int month, int year) {
		return LocalDate.of(year, month, 1);
	}
}
