package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by izeye on 15. 3. 6..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port=0")
public class WelcomeControllerTests {

	@Value("${local.server.port}")
	int port;

	RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testJspWithEl() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.TEXT_HTML));
		HttpEntity<Void> request = new HttpEntity<Void>(headers);
		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:{port}", HttpMethod.GET, request, String.class, this.port);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody(), containsString("/resources/text.txt"));
	}

	@Test
	public void testThymeleaf() {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:{port}/hello", String.class, this.port);
		assertThat(entity.getStatusCode(), is(HttpStatus.OK));
		assertThat(entity.getBody(), is("Hello, Thymeleaf!"));
	}

}
