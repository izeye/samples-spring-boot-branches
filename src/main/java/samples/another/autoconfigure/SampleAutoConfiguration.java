package samples.another.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import samples.another.service.SampleService;

/**
 * Created by izeye on 15. 2. 28..
 */
@ConditionalOnMissingBean(SampleService.class)
@Configuration
public class SampleAutoConfiguration {

	@Bean
	public SampleService sampleService(
			@Value("${value:defaultValue}") String someValue) {
		return new SampleService(someValue);
	}

}
