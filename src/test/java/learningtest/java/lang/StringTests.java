package learningtest.java.lang;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
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
	
	@Test
	public void testReplaceAll() {
		String expected = "Hello, world! Hello, world!";
		String message = "Hello, <!-- This shouldn't be displayed! -->world! Hello, <!-- This shouldn't be displayed! -->world!";
		assertThat(message.replaceAll("<!--.*?-->", ""), is(expected));
	}
	
}
