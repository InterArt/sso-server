package am.profclub.authserver;

import org.springframework.context.annotation.*;
import org.springframework.security.access.expression.method.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.oauth2.provider.expression.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Bean(name = "authenticationManagerBean")
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}/*

	@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
	private static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {

		@Override
		protected MethodSecurityExpressionHandler createExpressionHandler() {
			return new OAuth2MethodSecurityExpressionHandler();
		}
	}*/
}
