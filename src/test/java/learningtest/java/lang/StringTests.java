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
	
	@Test
	public void testSplit() {
		String delimiterRegEx = "[&=]";
		testDelimiterRegEx(delimiterRegEx);
		
		delimiterRegEx = "&|=";
		testDelimiterRegEx(delimiterRegEx);
	}

	private void testDelimiterRegEx(String delimiterRegEx) {
		String parameters = "id=1&name=Johnny&age=35";

		String[] split = parameters.split(delimiterRegEx);

		assertThat(split[0], is("id"));
		assertThat(split[1], is("1"));
		assertThat(split[2], is("name"));
		assertThat(split[3], is("Johnny"));
		assertThat(split[4], is("age"));
		assertThat(split[5], is("35"));
	}

}
