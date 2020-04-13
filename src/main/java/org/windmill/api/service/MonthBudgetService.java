package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.MonthBudget;

public interface MonthBudgetService {
	MonthBudget get(int month, int year);

	MonthBudget create(int month, int year);

	MonthBudget reconcile(int month, int year);

	List<MonthBudget> list();
}
