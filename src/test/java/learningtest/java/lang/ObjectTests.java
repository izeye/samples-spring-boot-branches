package learningtest.java.lang;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by izeye on 15. 4. 5..
 */
public class ObjectTests {
	
	@Test
	public void testClone() {
		int[] ints = new int[] {1, 2, 3};
		
		int[] clonedInts = ints.clone();
		
		assertTrue(Arrays.equals(ints, clonedInts));
		assertFalse(ints == clonedInts);
	}
	
}
