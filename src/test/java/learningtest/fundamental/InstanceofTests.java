package learningtest.fundamental;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by izeye on 15. 5. 8..
 */
public class InstanceofTests {
	
	@Test
	public void testNull() {
		Object object = null;
		assertFalse(object instanceof Object);
	}
	
}
