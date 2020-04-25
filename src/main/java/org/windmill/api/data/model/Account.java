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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	public Account(String account, Long insituationId, Long accountTypeId, boolean activeIndicator) {
		this.account = account;
		this.institution = new Institution(insituationId, null);
		this.accountType = new AccountType(accountTypeId, null, false);
		this.activeIndicator = activeIndicator;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_generator")
	@SequenceGenerator(name = "account_generator", sequenceName = "account_seq", allocationSize = 50)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "institution_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Institution institution;

	private String account;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "accountType_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AccountType accountType;

	private boolean activeIndicator;

}
