package learningtest.org.springframework.boot.bind;

import lombok.Data;
import org.junit.Test;
import org.springframework.boot.bind.PropertySourcesPropertyValues;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.mock.env.MockEnvironment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 29..
 */
public class RelaxedDataBinderTests {
	
	@Test
	public void testBind() {
		long id = 1L;
		String name = "Test";
		
		MockEnvironment env = new MockEnvironment();
		env.setProperty("some.id", String.valueOf(id));
		env.setProperty("some.name", name);
		
		SomeProperties someProperties = new SomeProperties();
		new RelaxedDataBinder(someProperties, "some").bind(
				new PropertySourcesPropertyValues(env.getPropertySources()));
		
		assertThat(someProperties.getId(), is(id));
		assertThat(someProperties.getName(), is(name));
	}
	
	@Data
	static class SomeProperties {
		private long id;
		private String name;
	}
	
}
