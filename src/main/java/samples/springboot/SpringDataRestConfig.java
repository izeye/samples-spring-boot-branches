package samples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.annotation.PostConstruct;

/**
 * Created by izeye on 15. 2. 27..
 */
@Configuration
public class SpringDataRestConfig {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	@PostConstruct
	public void init() {
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
	}

}
