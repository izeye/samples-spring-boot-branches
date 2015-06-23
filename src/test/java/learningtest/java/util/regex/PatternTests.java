package learningtest.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 23..
 */
public class PatternTests {
	
	@Test
	public void test() {
		String expected = "http://localhost/persons/search/name=&name=John&age=35&country=KR";
		
		String url = "http://localhost/persons/search/name=&name=John&age=35&country=KR";
		String newName = "John";
		
		Pattern pattern = Pattern.compile("name=(.*?)&");
		Matcher matcher = pattern.matcher(url);
		while (matcher.find()) {
			// NOTE: `0` will be the whole matched string.
			String name = matcher.group(1);
			if (name.isEmpty()) {
				continue;
			}
			url = url.replace(name, newName);
		}
		assertThat(url, is(expected));
	}
	
}
