package org.windmill.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.windmill.api.data.model.BudgetGroup;

@Repository
public interface BudgetGroupRepository extends JpaRepository<BudgetGroup, Long> {

}
