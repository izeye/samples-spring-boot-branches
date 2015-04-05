package samples.springboot;

import org.junit.Test;
import samples.springboot.util.ArrayUtils;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by izeye on 15. 4. 5..
 */
public class ArrayUtilsTests {
	
	@Test
	public void testCopy() {
		int[][] ints = new int[2][2];
		ints[0][0] = 1;
		ints[0][1] = 2;
		ints[1][0] = 3;
		ints[1][1] = 4;
		
		int[][] copiedInts = ArrayUtils.copy(ints);
		
		for (int i = 0; i < copiedInts.length; i++) {
			assertTrue(Arrays.equals(ints[i], copiedInts[i]));
			assertFalse(ints[i] == copiedInts[i]);
		}
	}
	
}
