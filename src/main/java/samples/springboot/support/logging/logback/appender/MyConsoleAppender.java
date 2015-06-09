package samples.springboot.support.logging.logback.appender;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * Created by izeye on 15. 6. 8..
 */
public class MyConsoleAppender extends AppenderBase<ILoggingEvent> {
	
	private Object object;
	
	@Override
	protected void append(ILoggingEvent eventObject) {
		if (eventObject.getLevel() == Level.INFO) {
			System.out.println(String.format("MyConsoleAppender (%s): %s", object, eventObject));
		}
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
