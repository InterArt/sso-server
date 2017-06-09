package am.profclub.authserver;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.oauth2.config.annotation.configurers.*;
import org.springframework.security.oauth2.config.annotation.web.configuration.*;
import org.springframework.security.oauth2.config.annotation.web.configurers.*;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.*;
import org.springframework.security.web.util.matcher.*;

/**
 * Created by admin on 6/2/17.
 */
@Configuration
public class OAuth2Configuration {

	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {

			http.csrf()
				.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
				.disable()
				.headers()
				.frameOptions().disable();
		}
	}


	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

		@Bean
		public TokenStore tokenStore() {
			return new InMemoryTokenStore();
		}

		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;


		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.tokenStore(tokenStore())
				.authenticationManager(authenticationManager);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory()
				.withClient("client_1")
				.scopes("read", "write")
				.authorities(Authorities.ROLE_ADMIN.name(), Authorities.ROLE_USER.name())
				.authorizedGrantTypes("password", "refresh_token")
				.secret("client_1_secret")
			.and()
				.withClient("client_2")
				.scopes("read", "write")
				.authorities(Authorities.ROLE_ADMIN.name())
				.authorizedGrantTypes("password", "refresh_token")
				.secret("client_2_secret")
			.and()
				.withClient("client_3")
				.scopes("read")
				.authorities(Authorities.ROLE_ANONYMOUS.name())
				.authorizedGrantTypes("password", "refresh_token")
				.secret("client_3_secret")
			;
		}
	}


}
