package org.windmill.api.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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
public class BudgetCategory {

	public BudgetCategory(String name, Integer position, BudgetGroup budgetGroup, Account savingsAccount,
			boolean utilityIndicator) {
		this.name = name;
		this.position = position;
		this.budgetGroup = budgetGroup;
		this.savingsAccount = savingsAccount;
		this.utilityIndicator = utilityIndicator;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budgetCategory_generator")
	@SequenceGenerator(name = "budgetCategory_generator", sequenceName = "budgetCategory_seq", allocationSize = 50)
	private Long id;
	private String name;
	private Integer position;
	private boolean utilityIndicator;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "budgetGroup_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BudgetGroup budgetGroup;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "savingsAccount_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Account savingsAccount;
}
