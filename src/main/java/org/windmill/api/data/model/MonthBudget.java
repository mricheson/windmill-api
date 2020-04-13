package org.windmill.api.data.model;

import java.time.LocalDate;

import javax.persistence.Column;
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
public class MonthBudget {

	public MonthBudget(LocalDate date, boolean reconciledIndicator) {
		this.reconciledIndicator = reconciledIndicator;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private LocalDate date;
	private boolean reconciledIndicator;
}
