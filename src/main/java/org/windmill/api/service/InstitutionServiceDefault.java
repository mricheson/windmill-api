package org.windmill.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windmill.api.data.model.Institution;
import org.windmill.api.data.repository.InsititutionRepository;

@Service
public class InstitutionServiceDefault implements InstitutionService {

	@Autowired
	private InsititutionRepository insititutionRepository;
	
	@Override
	public Institution create(Institution institution) {
		return insititutionRepository.save(institution);
	}

	@Override
	public Institution uupdate(Institution institution) {
		return insititutionRepository.save(institution);
	}

	@Override
	public List<Institution> list() {
		return insititutionRepository.findAll();
	}
}
