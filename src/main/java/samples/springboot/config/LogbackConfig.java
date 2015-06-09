package samples.springboot.config;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import samples.springboot.support.logging.logback.appender.MyConsoleAppender;

import javax.annotation.PostConstruct;

/**
 * Created by izeye on 15. 6. 9..
 */
@Configuration
public class LogbackConfig {
	
	@PostConstruct
	public void config() {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		Logger logger = lc.getLogger("ROOT");
		MyConsoleAppender appender = (MyConsoleAppender) logger.getAppender("MY_CONSOLE");
		appender.setObject("izeye");
	}
	
}
