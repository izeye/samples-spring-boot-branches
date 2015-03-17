package learningtest.org.springframework.test.util;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 3. 17..
 */
public class ReflectionTestUtilsTests {

	@Test
	public void test() {
		String name = "Johnny";
		Person person = new Person();
		person.setName(name);
		assertThat(person.getName(), is(name));

		String newName = "John";
		ReflectionTestUtils.setField(person, "name", newName);
		assertThat(person.getName(), is(newName));
	}

	class Person {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					'}';
		}
	}

}
