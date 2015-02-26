package samples.springboot;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 2. 27..
 */
public class PersonTests {

	@Test
	public void test() {
		String name = "Johnny";
		int age = 35;
		Person person = new Person(name, age);
		assertThat(person.getName(), is(name));
		assertThat(person.getAge(), is(age));
	}

}
