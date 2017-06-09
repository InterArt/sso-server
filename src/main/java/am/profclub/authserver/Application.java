package am.profclub.authserver;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.security.oauth2.config.annotation.web.configuration.*;

/**
 * Created by admin on 6/2/17.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
