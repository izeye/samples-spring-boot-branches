package samples.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 3. 21..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SampleAsyncServiceTests {

	@Autowired
	SampleAsyncService sampleAsyncService;

	@Test
	public void echoWithDelayInMillis() throws ExecutionException, InterruptedException {
		String text = "Johnny";
		long delayInMillis = 1000;

		long startTime = System.currentTimeMillis();
		Future<String> future = sampleAsyncService.echoWithDelayInMillis(text, delayInMillis);
		long elapsedTime = System.currentTimeMillis() - startTime;

		assertThat(elapsedTime, is(lessThan(delayInMillis)));
		assertThat(future.get(), is(text));
	}

	@Test
	public void invokeEchoWithDelayInMillisInternally()
			throws ExecutionException, InterruptedException {
		String text = "Johnny";
		long delayInMillis = 1000;

		long startTime = System.currentTimeMillis();
		Future<String> future = sampleAsyncService.invokeEchoWithDelayInMillisInternally(
				text, delayInMillis);
		long elapsedTime = System.currentTimeMillis() - startTime;

		// This is because `@Async` is based on auto-proxy.
		assertThat(elapsedTime, is(greaterThan(delayInMillis)));
		assertThat(future.get(), is(text));
	}

}
