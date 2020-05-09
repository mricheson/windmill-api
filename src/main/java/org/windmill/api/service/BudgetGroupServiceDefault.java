package org.windmill.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windmill.api.data.model.BudgetGroup;
import org.windmill.api.data.repository.BudgetGroupRepository;

@Service
public class BudgetGroupServiceDefault implements BudgetGroupService {

	@Autowired
	private BudgetGroupRepository budgetGroupRepository;

	@Override
	public BudgetGroup create(BudgetGroup budgetGroup) {
		return budgetGroupRepository.save(budgetGroup);
	}

	@Override
	public BudgetGroup update(Long id, BudgetGroup budgetGroup) {
		if (!id.equals(budgetGroup.getId())) {
			throw new RuntimeException("budget group ids must match");
		}
		return budgetGroupRepository.save(budgetGroup);
	}

	@Override
	public List<BudgetGroup> list() {
		return budgetGroupRepository.findAll();
	}
}
