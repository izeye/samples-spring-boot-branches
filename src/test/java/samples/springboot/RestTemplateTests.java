package samples.springboot;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.fail;

/**
 * Created by izeye on 15. 3. 12..
 */
public class RestTemplateTests {

	RestTemplate restTemplate;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory
				= (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
		requestFactory.setConnectTimeout(1000);
		requestFactory.setReadTimeout(1000);
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
	}

}
