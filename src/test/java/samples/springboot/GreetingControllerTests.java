package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 3. 11..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class GreetingControllerTests {

	@Value("${local.server.port}")
	int port;

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void test() {
		Greeting greeting = restTemplate.getForObject(
				"http://localhost:{port}/greeting", Greeting.class, port);
		assertThat(greeting.getId(), is(1L));
		assertThat(greeting.getContent(), is("Hello, World!"));

		greeting = restTemplate.getForObject(
				"http://localhost:{port}/greeting?name=Johnny", Greeting.class, port);
		assertThat(greeting.getId(), is(2L));
		assertThat(greeting.getContent(), is("Hello, Johnny!"));
	}

}
