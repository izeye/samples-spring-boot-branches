package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

/**
 * Created by izeye on 15. 2. 27..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	MyAppProperties myAppProperties;

	@Test
	public void test() {
		assertThat(myAppProperties.getSomeValues().get("a"), is("b"));
		assertThat(myAppProperties.getSomeValues().get("foo"), is("bar"));

		assertThat(myAppProperties.getClazz(), is(sameInstance(String.class)));
		assertThat(myAppProperties.getClasses(), is(Arrays.asList(String.class, Integer.class)));
	}

}
