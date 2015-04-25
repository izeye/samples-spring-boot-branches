package learningtest.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by izeye on 15. 4. 25..
 */
public class StringTests {
	
	@Test
	public void testMatches() {
		String regexp = "/[^/]*";
		assertFalse("test".matches(regexp));
		assertTrue("/test".matches(regexp));
		assertFalse("test/hello".matches(regexp));
		assertFalse("/test/hello".matches(regexp));
		
		regexp = "/.*";
		assertFalse("test".matches(regexp));
		assertTrue("/test".matches(regexp));
		assertFalse("test/hello".matches(regexp));
		assertTrue("/test/hello".matches(regexp));
	}
	
}
