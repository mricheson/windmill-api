package org.windmill.api.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log
public class BudgetGroup {

	public BudgetGroup(String name, Integer position, boolean savingsIndicator) {
		this.savingsIndicator = savingsIndicator;
		this.name = name;
		this.position = position;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budgetGroup_generator")
	@SequenceGenerator(name = "budgetGroup_generator", sequenceName = "budgetGroup_seq", allocationSize = 50)
	private Long id;
	private String name;
	private boolean savingsIndicator;
	private Integer position;
}
