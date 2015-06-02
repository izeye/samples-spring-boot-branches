package learningtest.ch.qos.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.apache.log4j.MDC;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by izeye on 15. 3. 25..
 */
public class LogbackTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		logger.debug("Hello, world!");
	}

	@Test
	public void testStatusPrinter() {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
	}
	
	@Test
	public void testMdc() {
		logger.debug("Test MDC.");
		
		MDC.put("sessionId", 1234);
		logger.debug("Test MDC.");
	}

}
