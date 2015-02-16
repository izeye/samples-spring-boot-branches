package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 2. 16..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles({"profile1", "profile2"})
public class ApplicationProfile1And2Tests {

	@Value("${string}")
	String string;

	@Test
	public void test() {
		// NOTE:
		// The order in @ActiveProfiles doesn't matter.
//		assertThat(string, is("profile 1"));
		assertThat(string, is("profile 2"));
	}

}
