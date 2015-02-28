package learningtest.org.springframework.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.EnvironmentTestUtils;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 2. 28..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EnvironmentTestUtilsTests {

	@Autowired
	ConfigurableEnvironment environment;

	@Test
	public void test() {
		EnvironmentTestUtils.addEnvironment(environment, "org=Spring", "name=Boot");
		assertThat(environment.getProperty("org"), is("Spring"));
		assertThat(environment.getProperty("name"), is("Boot"));
	}

}
