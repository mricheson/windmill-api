package org.windmill.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.windmill.api.data.model.BudgetTemplate;
import org.windmill.api.data.model.MonthBudget;
import org.windmill.api.data.model.MonthBudgetPlan;
import org.windmill.api.data.repository.BudgetTemplateRepository;
import org.windmill.api.data.repository.MonthBudgetPlanRepository;
import org.windmill.api.data.repository.MonthBudgetRepository;

@Service
public class MonthBudgetServiceDefault implements MonthBudgetService {

	@Autowired
	private MonthBudgetRepository monthBudgetRepository;

	@Autowired
	private MonthBudgetPlanRepository monthBudgetPlanRepository;

	@Autowired
	private BudgetTemplateRepository budgetTemplateRepository;

	@Override
	public List<MonthBudget> list() {
		return monthBudgetRepository.findAll();
	}

	@Override
	public MonthBudget get(int month, int year) {
		return monthBudgetRepository.getByDate(buildDateFromParts(month, year));
	}

	@Override
	@Transactional
	public MonthBudget create(int month, int year) {
		MonthBudget newMonthBudget = new MonthBudget(buildDateFromParts(month, year), false);
		monthBudgetRepository.save(newMonthBudget);

		budgetTemplateRepository.findAll().stream().map(budgetCategory -> buildPlan(budgetCategory, newMonthBudget))
				.forEach(monthBudgetPlanRepository::save);

		return newMonthBudget;
	}

	@Override
	public MonthBudget reconcile(int month, int year) {
		MonthBudget monthBudget = monthBudgetRepository.getByDate(buildDateFromParts(month, year));

		if (monthBudget.isReconciledIndicator()) {
			throw new RuntimeException("already reconciled");
		}

		monthBudget.setReconciledIndicator(true);
		return monthBudgetRepository.save(monthBudget);
	}

	LocalDate buildDateFromParts(int month, int year) {
		return LocalDate.of(year, month, 1);
	}

	MonthBudgetPlan buildPlan(BudgetTemplate budgetTemplate, MonthBudget monthBudget) {
		return new MonthBudgetPlan(budgetTemplate.getAmount(), budgetTemplate.getBudgetCategory(),
				budgetTemplate.getDescription(), monthBudget);
	}
}
