package samples.http.util;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 20..
 */
public class ArrayUtilsTests {
	
	@Test
	public void testIndexOf() {
		String value = "Hello, world! Hello, world!";
		
		int index = ArrayUtils.indexOf(value.getBytes(), (byte) ',');
		assertThat(index, is(5));
		
		index = ArrayUtils.indexOf(value.getBytes(), (byte) ',', index + 1);
		assertThat(index, is(19));
	}
	
	@Test
	public void testSubarray() {
		String value = "Hello, world!";
		assertThat(new String(ArrayUtils.subarray(value.getBytes(), 2, 4)), is("ll"));
	}
	
}
