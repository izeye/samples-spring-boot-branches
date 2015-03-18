package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by izeye on 15. 3. 6..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class HomeControllerTests {

	@Value("${local.server.port}")
	int port;

	RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void test() {
		String response = restTemplate.getForObject(
				"http://localhost:{port}/", String.class, port);
		assertThat(response, containsString("Johnny"));
	}

}
