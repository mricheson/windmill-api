package org.windmill.api.data.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthBudgetCategory {

	public MonthBudgetCategory(BigDecimal amount, BudgetCategory budgetCategory, String description,
			MonthBudget monthBudget) {
		this.amount = amount;
		this.monthBudget = monthBudget;
		this.budgetCategory = budgetCategory;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "monthBudget_id", nullable = false)
	private MonthBudget monthBudget;

	@Column(precision = 10, scale = 2)
	private BigDecimal amount;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "budgetCategory_id", nullable = false)
	private BudgetCategory budgetCategory;

	private String description;

}
