package org.windmill.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windmill.api.data.model.SavingsEntry;
import org.windmill.api.data.repository.SavingsEntryRepository;

@Service
public class SavingsEntryServiceDefault implements SavingsEntryService {

	@Autowired
	private SavingsEntryRepository savingsEntryRepository;

	@Override
	public SavingsEntry create(SavingsEntry savingsEntry) {
		return savingsEntryRepository.save(savingsEntry);
	}

	@Override
	public SavingsEntry update(Long id, SavingsEntry savingsEntry) {
		if (!id.equals(savingsEntry.getId())) {
			throw new RuntimeException("savings entry ids must match");
		}
		return savingsEntryRepository.save(savingsEntry);
	}

	@Override
	public List<SavingsEntry> list() {
		return savingsEntryRepository.findAll();
	}
}
