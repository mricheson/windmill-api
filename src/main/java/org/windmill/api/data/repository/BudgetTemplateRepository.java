package org.windmill.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.windmill.api.data.model.BudgetTemplate;

@Repository
public interface BudgetTemplateRepository extends JpaRepository<BudgetTemplate, Long> {

}
