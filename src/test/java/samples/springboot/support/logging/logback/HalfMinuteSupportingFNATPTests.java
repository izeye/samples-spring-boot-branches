package samples.springboot.support.logging.logback;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by izeye on 15. 3. 30..
 */
public class HalfMinuteSupportingFNATPTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Ignore
	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			logger.debug("Log message #{}", i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
