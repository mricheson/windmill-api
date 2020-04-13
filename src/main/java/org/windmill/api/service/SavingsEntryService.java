package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.SavingsEntry;

public interface SavingsEntryService {
	SavingsEntry create(SavingsEntry savingsEntry);

	SavingsEntry update(Long id, SavingsEntry savingsEntry);

	List<SavingsEntry> list();
}
