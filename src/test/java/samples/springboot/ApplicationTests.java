package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 2. 24..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class ApplicationTests {

	@Value("${local.server.port}")
	int serverPort;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void test() {
		String response = restTemplate.getForObject(
				"http://localhost:{serverPort}/hello", String.class, serverPort);
		System.out.println(response);
		assertThat(response, is("Hello"));
	}

}
