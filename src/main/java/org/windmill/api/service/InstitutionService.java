package org.windmill.api.service;

import java.util.List;

import org.windmill.api.data.model.Institution;

public interface InstitutionService {
	Institution create(Institution institution);

	Institution update(Long id, Institution institution);

	List<Institution> list();
}
