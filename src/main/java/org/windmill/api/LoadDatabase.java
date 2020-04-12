package org.windmill.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.windmill.api.data.model.Account;
import org.windmill.api.data.model.AccountType;
import org.windmill.api.data.model.BudgetCategory;
import org.windmill.api.data.model.BudgetGroup;
import org.windmill.api.data.model.Institution;
import org.windmill.api.data.repository.AccountRepository;
import org.windmill.api.data.repository.AccountTypeRepository;
import org.windmill.api.data.repository.BudgetCategoryRepository;
import org.windmill.api.data.repository.BudgetGroupRepository;
import org.windmill.api.data.repository.InsititutionRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(AccountTypeRepository accountTypeRepository,
			InsititutionRepository instituationRepository, AccountRepository accountRepository,
			BudgetCategoryRepository budgetCategoryRepository, BudgetGroupRepository budgetGroupRepository) {
		return args -> {
			AccountType checking = accountTypeRepository.save(new AccountType("Checking", false));
			log.info("Preloading " + checking);
			AccountType savings = accountTypeRepository.save(new AccountType("Savings", true));
			log.info("Preloading " + savings);
			AccountType credit = accountTypeRepository.save(new AccountType("Credit", false));
			log.info("Preloading " + credit);

			Institution chase = instituationRepository.save(new Institution("Chase"));
			log.info("Preloading " + chase);
			Institution firthThird = instituationRepository.save(new Institution("Fifth Third"));
			log.info("Preloading " + firthThird);

			Account reserve = accountRepository
					.save(new Account("Sapphire Reserve", chase.getId(), credit.getId(), true));
			log.info("Preloading " + reserve);
			Account preferred = accountRepository
					.save(new Account("Sapphire Preferred", chase.getId(), credit.getId(), false));
			log.info("Preloading " + preferred);

			BudgetGroup fixedIncome = budgetGroupRepository.save(new BudgetGroup("Fixed Income", 0, false));
			log.info("Preloading " + fixedIncome);
			BudgetGroup fixedExpense = budgetGroupRepository.save(new BudgetGroup("Fixed Expense", 1, false));
			log.info("Preloading " + fixedExpense);

			BudgetCategory dmi = budgetCategoryRepository.save(new BudgetCategory("DMI", 0, fixedIncome, null, false));
			log.info("Preloading " + dmi);
			BudgetCategory bonus = budgetCategoryRepository
					.save(new BudgetCategory("Bonus", 1, fixedIncome, preferred, false));
			log.info("Preloading " + bonus);

		};
	}
}