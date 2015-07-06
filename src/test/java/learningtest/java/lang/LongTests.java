package learningtest.java.lang;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * Created by izeye on 15. 7. 6..
 */
public class LongTests {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testEquals() {
		Long longAsWrapper = new Long(1L);
		long longAsPrimitive = 1L;
		assertTrue(longAsWrapper == longAsPrimitive);
	}

	@Test
	public void testEqualsWithNull() {
		thrown.expect(NullPointerException.class);
		Long longAsWrapper = null;
		long longAsPrimitive = 1L;
		System.out.println(longAsWrapper == longAsPrimitive);
	}
	
}
