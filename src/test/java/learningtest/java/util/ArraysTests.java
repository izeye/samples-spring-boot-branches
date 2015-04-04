package learningtest.java.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 4. 4..
 */
public class ArraysTests {
	
	@Test
	public void testAsList() {
		List<int[]> intArrayAsList = Arrays.asList(new int[]{1, 2, 3});
		assertThat(intArrayAsList.size(), is(1));
		
		List<Integer> integerArrayAsList = Arrays.asList(new Integer[]{1, 2, 3});
		assertThat(integerArrayAsList.size(), is(3));
	}
	
}
