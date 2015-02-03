package samples.springboot;

import ch.qos.logback.classic.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by izeye on 15. 2. 3..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class LoggerTests {

	@Test
	public void test() {
		printLoggerLevel("org.springframework.boot");
		printLoggerLevel("org.thymeleaf");
	}

	private void printLoggerLevel(String loggerName) {
		Logger logger = (Logger) LoggerFactory.getLogger(loggerName);
		System.out.println("Level: " + logger.getLevel());
		System.out.println("Effective level: " + logger.getEffectiveLevel());
		logger.trace("test");
	}

}
