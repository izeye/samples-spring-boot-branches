package learningtest.com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 1..
 */
public class ObjectMapperTests {
	
	@Test
	public void testWriteValue() throws IOException {
		StringWriter sw = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(sw, new Foo("test"));
		assertThat(sw.toString(), is("{\"bar\":\"test\"}"));
	}
	
	static class Foo {
		private final String bar;

		Foo(String bar) {
			this.bar = bar;
		}

		public String getBar() {
			return bar;
		}
	}
	
}
