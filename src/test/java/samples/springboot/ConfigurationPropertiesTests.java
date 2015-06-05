package samples.springboot;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 5..
 */
public class ConfigurationPropertiesTests {

	@Test
	public void test() {
		ConfigurableApplicationContext context = SpringApplication.run(Config.class);

		Config config = context.getBean(Config.class);
		System.out.println(config.myAppProperties);
	}
	
	@Test
	public void testWithCustom() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ConfigWithCustom.class);
		context.refresh();

		ConfigWithCustom configWithCustom = context.getBean(ConfigWithCustom.class);
		assertThat(configWithCustom.viewNames.getPc(), is("view/pc"));
		assertThat(configWithCustom.viewNames.getMobile(), is("view/mobile"));
	}

	@SpringBootApplication
	static class Config {
		@Autowired
		MyAppProperties myAppProperties;
	}
	
	@EnableConfigurationProperties(ViewNames.class)
	static class ConfigWithCustom {
		@Autowired
		ViewNames viewNames;
	}
	
}
