package samples.http.util;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 20..
 */
public class IoUtilsTests {
	
	@Test
	public void testToByteArray() {
		String value = "Hello, world!";
		InputStream is = new ByteArrayInputStream(value.getBytes());
		assertThat(new String(IoUtils.toByteArray(is)), is(value));
	}
	
}
