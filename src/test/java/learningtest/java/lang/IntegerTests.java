package learningtest.java.lang;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 20..
 */
public class IntegerTests {
	
	@Test
	public void testParseInt() {
		int expected = 86671;
		String hex = "1528f";
		assertThat(Integer.parseInt(hex, 16), is(expected)); 
	}
	
}
