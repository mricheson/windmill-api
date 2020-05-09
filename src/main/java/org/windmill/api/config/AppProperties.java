package org.windmill.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	private final Auth auth = new Auth();
	private final OAuth2 oauth2 = new OAuth2();

	@Getter
	@Setter
	public static class Auth {
		private String tokenSecret;
		private long tokenExpirationMsec;
	}

	@Getter
	@Setter
	public static final class OAuth2 {

		private String authorizedRedirect;
	}
}
