package samples.springboot;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

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

	@Value("${security.user.name}")
	String username;

	@Value("${security.user.password}")
	String password;

	RestTemplate restTemplate = new RestTemplate();
	
	TestRestTemplate testRestTemplate;

	@Before
	public void setUp() {
		this.testRestTemplate = new TestRestTemplate(this.username, this.password);
	}

	@Test
	public void testWithRestTemplate() throws UnsupportedEncodingException {
		String credentials = this.username + ":" + this.password;
		String base64EncodedCredentials = Base64.encode(credentials.getBytes("UTF-8"));

		String authorizationHeaderName = "Authorization";
		String authorizationHeaderValue = "Basic " + base64EncodedCredentials;

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set(authorizationHeaderName, authorizationHeaderValue);

		HttpEntity<Void> request = new HttpEntity<>(httpHeaders);
		ResponseEntity<Greeting> response = this.restTemplate.exchange(
				"http://localhost:{port}/greeting", HttpMethod.GET, request, Greeting.class, this.port);
		assertThat(response.getBody().getContent(), is("Hello, World!"));

		response = this.restTemplate.exchange(
				"http://localhost:{port}/greeting?name=Johnny",
				HttpMethod.GET, request, Greeting.class, this.port);
		assertThat(response.getBody().getContent(), is("Hello, Johnny!"));
	}

	@Test
	public void testWithTestRestTemplate() {
		Greeting greeting = this.testRestTemplate.getForObject(
				"http://localhost:{port}/greeting", Greeting.class, this.port);
		assertThat(greeting.getContent(), is("Hello, World!"));

		greeting = this.testRestTemplate.getForObject(
				"http://localhost:{port}/greeting?name=Johnny", Greeting.class, this.port);
		assertThat(greeting.getContent(), is("Hello, Johnny!"));
	}

}
