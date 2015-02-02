package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ViewResolver;

import java.util.Map;

/**
 * Created by izeye on 15. 2. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port=0")
public class ApplicationContextTests {

	@Autowired
	ApplicationContext context;

	@Test
	public void testViewResolvers() {
		Map<String, ViewResolver> beansOfType = context.getBeansOfType(ViewResolver.class);
		for (ViewResolver viewResolver : beansOfType.values()) {
			System.out.println(viewResolver + ": " + ((Ordered) viewResolver).getOrder());
		}
	}

}
