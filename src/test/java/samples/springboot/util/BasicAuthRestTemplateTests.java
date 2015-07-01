package samples.springboot.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;
import samples.springboot.Greeting;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 7. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class BasicAuthRestTemplateTests {

	@Value("${local.server.port}")
	int port;

	@Value("${security.user.name}")
	String username;

	@Value("${security.user.password}")
	String password;

	BasicAuthRestTemplate basicAuthRestTemplate;
	
	@Before
	public void setUp() {
		this.basicAuthRestTemplate = new BasicAuthRestTemplate(this.username, this.password);
	}

	@Test
	public void test() {
		Greeting greeting = this.basicAuthRestTemplate.getForObject(
				"http://localhost:{port}/greeting", Greeting.class, this.port);
		assertThat(greeting.getContent(), is("Hello, World!"));

		greeting = this.basicAuthRestTemplate.getForObject(
				"http://localhost:{port}/greeting?name=Johnny", Greeting.class, this.port);
		assertThat(greeting.getContent(), is("Hello, Johnny!"));
	}
	
}
