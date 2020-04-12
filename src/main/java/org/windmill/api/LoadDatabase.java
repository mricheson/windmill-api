package org.windmill.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.windmill.api.data.model.AccountType;
import org.windmill.api.data.repository.AccountTypeRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(AccountTypeRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new AccountType("Checking", false)));
			log.info("Preloading " + repository.save(new AccountType("Savings", true)));
		};
	}
}