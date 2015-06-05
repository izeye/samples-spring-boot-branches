package samples.springboot;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 5..
 */
public class ViewNamesTests {
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();

		Config config = context.getBean(Config.class);
		assertThat(config.viewNames.getPc(), is("view/pc"));
		assertThat(config.viewNames.getMobile(), is("view/mobile"));
	}
	
	@EnableConfigurationProperties(ViewNames.class)
	static class Config {
		@Autowired
		ViewNames viewNames;
	}
	
}
