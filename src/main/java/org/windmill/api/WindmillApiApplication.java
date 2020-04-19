package org.windmill.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.windmill.api.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class WindmillApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WindmillApiApplication.class, args);
	}
}
