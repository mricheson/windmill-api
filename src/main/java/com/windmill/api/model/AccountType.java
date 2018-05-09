package com.windmill.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private boolean savingsIndicator;

	public Long getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSavingsIndicator() {
		return savingsIndicator;
	}

	public void setSavingsIndicator(boolean savingsIndicator) {
		this.savingsIndicator = savingsIndicator;
	}

}
