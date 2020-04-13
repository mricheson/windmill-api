package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.MonthBudgetCategory;

public interface MonthBudgetCategoryService {
	List<MonthBudgetCategory> list(int month, int year);
}
