package learningtest.org.springframework.boot.actuate.autoconfigure.trace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.TraceRepositoryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.TraceWebFilterAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import samples.springboot.Application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by izeye on 15. 6. 28..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
@ActiveProfiles("trace")
public class TraceEnableTests {

	@Value("${local.server.port}")
	int port;

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void test() {
		String beans = restTemplate.getForObject(
				"http://localhost:{port}/management/beans", String.class, port);
		assertThat(beans, containsString(TraceRepositoryAutoConfiguration.class.getName()));
		assertThat(beans, containsString(TraceWebFilterAutoConfiguration.class.getName()));
	}
	
}
