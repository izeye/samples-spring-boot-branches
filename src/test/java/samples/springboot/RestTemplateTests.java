package samples.springboot;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

/**
 * Created by izeye on 15. 3. 12..
 */
public class RestTemplateTests {

	private static final long DEFAULT_CONNECTION_TIMEOUT = 1000;
	private static final long DEFAULT_READ_TIMEOUT = 1000;

	RestTemplate restTemplate;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory
				= (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
		requestFactory.setConnectTimeout((int) DEFAULT_CONNECTION_TIMEOUT);
		requestFactory.setReadTimeout((int) DEFAULT_READ_TIMEOUT);
	}

	@Test
	public void test() {
		long startTime = System.currentTimeMillis();
		try {
			restTemplate.getForObject("http://1.2.3.4/", String.class);
			fail();
		} catch (ResourceAccessException ex) {
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(elapsedTime);
		assertThat(
				elapsedTime,
				is(both(greaterThan(DEFAULT_CONNECTION_TIMEOUT))
						.and(lessThan(DEFAULT_CONNECTION_TIMEOUT + 1000))));
	}

}
