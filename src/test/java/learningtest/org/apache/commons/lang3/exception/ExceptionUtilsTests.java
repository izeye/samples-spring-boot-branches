package learningtest.org.apache.commons.lang3.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

/**
 * Created by izeye on 15. 5. 27..
 */
public class ExceptionUtilsTests {
	
	@Test
	public void test() {
		try {
			throw new RuntimeException("test");
		} catch (RuntimeException ex) {
			System.out.println(ExceptionUtils.getMessage(ex));
			System.out.println(ExceptionUtils.getStackTrace(ex));
		}
	}
	
}
