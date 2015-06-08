package samples.springboot.support.logging.logback.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * Created by izeye on 15. 6. 8..
 */
public class MyConsoleAppender extends AppenderBase<ILoggingEvent> {
	
	@Override
	protected void append(ILoggingEvent eventObject) {
		System.out.println("MyConsoleAppender: " + eventObject);
	}
	
}
