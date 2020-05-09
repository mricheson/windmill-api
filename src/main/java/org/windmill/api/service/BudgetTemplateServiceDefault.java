package org.windmill.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windmill.api.data.model.BudgetTemplate;
import org.windmill.api.data.repository.BudgetTemplateRepository;

@Service
public class BudgetTemplateServiceDefault implements BudgetTemplateService {

	@Autowired
	private BudgetTemplateRepository budgetTemplateRepository;

	@Override
	public BudgetTemplate create(BudgetTemplate budgetTemplate) {
		return budgetTemplateRepository.save(budgetTemplate);
	}

	@Override
	public BudgetTemplate update(Long id, BudgetTemplate budgetTemplate) {
		if (!id.equals(budgetTemplate.getId())) {
			throw new RuntimeException("budget template ids must match");
		}
		return budgetTemplateRepository.save(budgetTemplate);
	}

	@Override
	public List<BudgetTemplate> list() {
		return budgetTemplateRepository.findAll();
	}
}
