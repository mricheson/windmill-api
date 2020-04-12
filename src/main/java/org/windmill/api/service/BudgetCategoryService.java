package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.BudgetCategory;

public interface BudgetCategoryService {
	BudgetCategory create(BudgetCategory budgetCategory);

	BudgetCategory update(Long id, BudgetCategory budgetCategory);

	List<BudgetCategory> list();
}
