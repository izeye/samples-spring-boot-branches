package learningtest.java.util.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

/**
 * Created by izeye on 15. 3. 23..
 */
public class StreamTests {

	@Test
	public void test() {
		List<Application> applications = Arrays.asList(
				new Application(1L), new Application(2L), new Application(3L));

		// Test sequential stream.
		long startTime = System.currentTimeMillis();
		applications.stream().forEach(application -> application.doStuff());
		long elapsedTime = System.currentTimeMillis() - startTime;

		assertThat(elapsedTime, is(greaterThan(900L)));

		// Test parallel stream.
		startTime = System.currentTimeMillis();
		applications.parallelStream().forEach(application -> application.doStuff());
		elapsedTime = System.currentTimeMillis() - startTime;

		assertThat(elapsedTime, is(lessThan(900L)));
	}

	class Application {
		private long id;

		public Application(long id) {
			this.id = id;
		}

		public void doStuff() {
			for (int i = 0; i < 3; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("Application #%d is working...", id));
			}
		}
	}

}
