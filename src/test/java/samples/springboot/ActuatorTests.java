package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Status;
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
public class ActuatorTests {

	@Value("${local.server.port}")
	int port;

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void test() {
		// NOTE:
		// I CAN NOT reuse `Health` in Actuator
		// because `Health` has no default constructor.
		Health health = restTemplate.getForObject(
				"http://localhost:{port}/management/health", Health.class, port);
		assertThat(health.getStatus(), is(Status.UP));
	}

	static class Health {
		private Status status;

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Health{" +
					"status=" + status +
					'}';
		}
	}

}
