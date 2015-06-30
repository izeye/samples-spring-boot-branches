package samples.springboot.counter.web;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import samples.springboot.Application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 30..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class CounterControllerTests {

	@Value("${local.server.port}")
	int port;

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testCount() {
		restTemplate.getForObject("http://localhost:{port}/counter", Void.class, port);
		String metrics = restTemplate.getForObject("http://localhost:{port}/management/metrics", String.class, port);
		
		// NOTE: 1L doesn't work. Why?
		assertThat(JsonPath.<Long> read(metrics, "['counter.test']"), is(1));
		assertThat(JsonPath.<Long> read(metrics, "$['counter.test']"), is(1));
		assertThat(JsonPath.<Long> read(metrics, "$.['counter.test']"), is(1));
		
		restTemplate.getForObject("http://localhost:{port}/counter", Void.class, port);
		metrics = restTemplate.getForObject("http://localhost:{port}/management/metrics", String.class, port);

		assertThat(JsonPath.<Long> read(metrics, "['counter.test']"), is(2));

		restTemplate.getForObject("http://localhost:{port}/counter", Void.class, port);
		metrics = restTemplate.getForObject("http://localhost:{port}/management/metrics", String.class, port);

		assertThat(JsonPath.<Long> read(metrics, "['counter.test']"), is(3));
	}
	
}
