package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.BudgetGroup;

public interface BudgetGroupService {
	BudgetGroup create(BudgetGroup budgetGroup);

	BudgetGroup update(Long id, BudgetGroup budgetGroup);

	List<BudgetGroup> list();
}
