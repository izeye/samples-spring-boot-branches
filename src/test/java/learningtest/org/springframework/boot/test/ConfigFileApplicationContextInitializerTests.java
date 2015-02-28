package learningtest.org.springframework.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 2. 28..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes = Application.class,
		initializers = ConfigFileApplicationContextInitializer.class
)
public class ConfigFileApplicationContextInitializerTests {

	@Value("${server.port}")
	int serverPort;

	@Test
	public void test() {
		assertThat(serverPort, is(18080));
	}

}
