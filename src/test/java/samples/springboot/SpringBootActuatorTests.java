package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.dropwizard.DropwizardMetricServices;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

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
	
	@Autowired
	CounterService counterService;

	@Test
	public void testMetrics() {
		String metrics = restTemplate.getForObject(
				"http://localhost:{port}/management/metrics", String.class, port);
		System.out.println(metrics);
	}
	
	@Test
	public void testCounterService() {
		assertThat(counterService, is(instanceOf(DropwizardMetricServices.class)));
	}
	
}
