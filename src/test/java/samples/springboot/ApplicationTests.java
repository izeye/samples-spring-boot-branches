package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by izeye on 15. 1. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

	@Autowired
	ApplicationContext context;

	@Autowired
	InternalResourceViewResolver internalResourceViewResolver;

	@Test
	public void testViewResolvers() {
		Map<String, ViewResolver> beansOfType = context.getBeansOfType(ViewResolver.class);
		for (ViewResolver viewResolver : beansOfType.values()) {
			System.out.println(viewResolver + ": " + ((Ordered) viewResolver).getOrder());
		}
	}

	@Test
	public void testInternalResourceViewResolver() {
		assertThat(internalResourceViewResolver, is(not(nullValue())));
	}

}
