package org.windmill.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windmill.api.data.model.BudgetCategory;
import org.windmill.api.data.repository.BudgetCategoryRepository;

@Service
public class BudgetCategoryServiceDefault implements BudgetCategoryService {

	@Autowired
	private BudgetCategoryRepository budgetCategoryRepository;

	@Override
	public BudgetCategory create(BudgetCategory budgetCategory) {
		return budgetCategoryRepository.save(budgetCategory);
	}

	@Override
	public BudgetCategory update(Long id, BudgetCategory budgetCategory) {
		if (!id.equals(budgetCategory.getId())) {
			throw new RuntimeException("budget category ids must match");
		}
		return budgetCategoryRepository.save(budgetCategory);
	}

	@Override
	public List<BudgetCategory> list() {
		return budgetCategoryRepository.findAll();
	}
}
