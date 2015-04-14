package learningtest.java.lang;

import org.junit.Test;

/**
 * Created by izeye on 15. 4. 14..
 */
public class RuntimeTests {
	
	@Test
	public void testAvailableProcessors() {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors);
	}
	
}
