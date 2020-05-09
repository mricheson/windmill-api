package org.windmill.api.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generator")
	@SequenceGenerator(name = "transaction_generator", sequenceName = "transaction_seq", allocationSize = 50)
	private Long id;

	private LocalDate transactionDate;

	private LocalDate postDate;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	private String description;

	@Column(precision = 10, scale = 2)
	private BigDecimal amount;

	private boolean reimbursable;

	private boolean reimbursement;

	private boolean payment;

	private boolean pending;

	private boolean split;

	private String comment;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "monthBudget_id", nullable = true)
	private MonthBudget monthBudget;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "budgetCategory_id", nullable = true)
	private BudgetCategory budgetCategory;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "parent_id", nullable = true)
	private Transaction parent;
}
