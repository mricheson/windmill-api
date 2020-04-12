package org.windmill.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.windmill.api.data.model.AccountType;
import org.windmill.api.data.model.Institution;
import org.windmill.api.data.repository.AccountTypeRepository;
import org.windmill.api.data.repository.InsititutionRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(AccountTypeRepository accountTypeRepository,
			InsititutionRepository instituationRepository) {
		return args -> {
			log.info("Preloading " + accountTypeRepository.save(new AccountType("Checking", false)));
			log.info("Preloading " + accountTypeRepository.save(new AccountType("Savings", true)));
			log.info("Preloading " + instituationRepository.save(new Institution("Chase")));
			log.info("Preloading " + instituationRepository.save(new Institution("Fifth Third")));
		};
	}
}