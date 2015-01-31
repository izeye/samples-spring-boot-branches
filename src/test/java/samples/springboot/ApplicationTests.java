package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by izeye on 15. 1. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port=0")
public class ApplicationTests {

	@Autowired
	InternalResourceViewResolver internalResourceViewResolver;

	@Value("${local.server.port}")
	int port;

	@Test
	public void testInternalResourceViewResolver() {
		assertThat(internalResourceViewResolver, is(not(nullValue())));
	}

	@Test
	public void testJspWithEl() {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:{port}", String.class, this.port);
		assertThat(entity.getStatusCode(), is(HttpStatus.OK));
		assertThat(entity.getBody(), containsString("/resources/text.txt"));
	}

}
