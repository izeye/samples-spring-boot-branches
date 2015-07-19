package learningtest.org.mockito;

import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Created by izeye on 15. 7. 19..
 */
public class MockTests {
	
	@Mock
	Person person;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		assertThat(person.getName(), is(nullValue()));
	}
	
	@Data
	static class Person {
		private Long id;
		private String name;
		private int age;
	}
	
}
