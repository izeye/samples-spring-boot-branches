package learningtest.org.springframework.beans;

import org.junit.Test;
import org.springframework.beans.DirectFieldAccessor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 11..
 */
public class DirectFieldAccessorTests {
	
	@Test
	public void testSetPropertyValue() {
		String name = "Johnny";
		Person person = new Person(name);
		assertThat(person.getName(), is(name));

		String newName = "John";
		DirectFieldAccessor accessor = new DirectFieldAccessor(person);
		accessor.setPropertyValue("name", newName);
		assertThat(person.getName(), is(newName));
	}
	
	static class Person {
		private String name;
		
		public Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	
}
