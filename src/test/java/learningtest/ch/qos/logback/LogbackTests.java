package learningtest.ch.qos.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by izeye on 15. 3. 25..
 */
public class LogbackTests {

	@Ignore
	@Test
	public void test() {
		String configFilename = "src/test/resources/logback-client.xml";
		configLogback(configFilename);

		Logger logger = LoggerFactory.getLogger(getClass());
		logger.debug("Hello, world!");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void runServerSocketReceiver() {
		String configFilename = "src/test/resources/logback-server.xml";
		configLogback(configFilename);
		
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void configLogback(String configFilename) {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		lc.reset();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		try {
			configurator.doConfigure(configFilename);
		} catch (JoranException e) {
			e.printStackTrace();
		}
	}

}
