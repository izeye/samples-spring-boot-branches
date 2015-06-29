package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by izeye on 15. 6. 29..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class SpringBootActuatorTests {

	@Value("${local.server.port}")
	int port;

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testMetrics() {
		String metrics = restTemplate.getForObject(
				"http://localhost:{port}/management/metrics", String.class, port);
		System.out.println(metrics);
	}
	
}
