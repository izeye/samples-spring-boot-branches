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
public class HomeControllerTests extends DummyTrustManagerSupport {

	@Value("${http.port}")
	int httpPort;

	@Value("${local.server.port}")
	int httpsPort;

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testHttp() {
		test("http", httpPort);
	}

	@Test
	public void testHttps() {
		test("https", httpsPort);
	}

	private void test(String scheme, int port) {
		String response = restTemplate.getForObject(
				"{scheme}://localhost:{port}/", String.class, scheme, port);
		assertThat(response, is("Hello World!"));
	}

}
