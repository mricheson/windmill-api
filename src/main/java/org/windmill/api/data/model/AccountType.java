package org.windmill.api.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log
public class AccountType {

	public AccountType(String type, boolean savingsIndicator) {
		this.savingsIndicator = savingsIndicator;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private boolean savingsIndicator;
}
