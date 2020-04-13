package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.BudgetTemplate;

public interface BudgetTemplateService {
	BudgetTemplate create(BudgetTemplate budgetTemplate);

	BudgetTemplate update(Long id, BudgetTemplate budgetTemplate);

	List<BudgetTemplate> list();
}
