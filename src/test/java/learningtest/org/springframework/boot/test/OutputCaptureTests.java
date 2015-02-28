package learningtest.org.springframework.boot.test;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by izeye on 15. 2. 28..
 */
public class OutputCaptureTests {

	@Rule
	public OutputCapture capture = new OutputCapture();

	@Test
	public void test() {
		System.out.println("Hello, world!");
		String captured = capture.toString();
		System.out.println(captured);
		assertThat(captured, containsString("Hello"));
	}

}
