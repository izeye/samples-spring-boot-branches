package samples.springboot.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 15. 6. 28..
 */
@Configuration
public class H2Config {
	
	@Bean
	public ServletRegistrationBean h2WebConsole() {
		return new ServletRegistrationBean(new WebServlet(), "/h2-console/*");
	}
	
}
