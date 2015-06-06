package learningtest.java.lang;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 6..
 */
public class BooleanTests {
	
	@Test
	public void testGetBoolean() {
		String name = "FIRST_NAME";
		
		assertThat(Boolean.getBoolean(name), is(false));
		
		System.setProperty(name, "true");
		assertThat(Boolean.getBoolean(name), is(true));
		
		System.setProperty(name, "TRUE");
		assertThat(Boolean.getBoolean(name), is(true));
		
		System.setProperty(name, "1");
		assertThat(Boolean.getBoolean(name), is(false));
	}
	
}
