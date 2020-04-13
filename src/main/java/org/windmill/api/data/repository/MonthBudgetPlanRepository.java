package org.windmill.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.windmill.api.data.model.MonthBudgetPlan;

@Repository
public interface MonthBudgetPlanRepository extends JpaRepository<MonthBudgetPlan, Long> {

}
