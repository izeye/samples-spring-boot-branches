package learningtest.org.mockito;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by izeye on 15. 3. 17..
 */
public class MockitoTests {

	@Test
	public void test() {
		String name = "John";
		Person person = mock(Person.class);
		when(person.getName()).thenReturn(name);
		assertThat(person.getName(), is(name));
	}

	@Test(expected = RuntimeException.class)
	public void testException() {
		Person person = mock(Person.class);
		when(person.getName()).thenThrow(new RuntimeException());
		person.getName();
	}

	@Test(expected = RuntimeException.class)
	public void testExceptionWithVoidReturn() {
		String name = "John";
		Person person = mock(Person.class);
		doThrow(new RuntimeException()).when(person).setName(anyString());
		person.setName(name);
	}

	@Test
	public void testVerify() {
		Person person = mock(Person.class);
		person.getName();
		person.getName();
		verify(person, times(2)).getName();
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
