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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log
public class BudgetTemplate {

	public BudgetTemplate(BigDecimal amount, String description, BudgetCategory budgetCategory) {
		this.amount = amount;
		this.description = description;
		this.budgetCategory = budgetCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(precision = 10, scale = 2)
	private BigDecimal amount;
	private String description;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "budgetCategory_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BudgetCategory budgetCategory;
}
