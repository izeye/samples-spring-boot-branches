package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 3. 4..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MessageSourceTests {

	@Resource(name = "customMessageSource")
	MessageSource messageSource;

	@Test
	public void testMessages() {
		String name = messageSource.getMessage("name", null, null);
//		assertThat(name, is("Johnny"));
		assertThat(name, is("John"));
	}

}
