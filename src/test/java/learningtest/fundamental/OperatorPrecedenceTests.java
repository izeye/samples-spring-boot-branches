package learningtest.fundamental;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by izeye on 15. 5. 8..
 */
public class OperatorPrecedenceTests {
	
	@Test
	public void testCastAndMultiply() {
		assertThat(((int) 10.1 * 100), is(1000));
		assertThat(((int) (10.1 * 100)), is(1010));
	}
	
}
