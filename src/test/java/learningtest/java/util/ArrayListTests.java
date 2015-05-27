package learningtest.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 5. 27..
 */
public class ArrayListTests {

	@Test
	public void testSubList() {
		List<String> strings = new ArrayList<>();
		strings.add("test1");
		strings.add("test2");
		
		List<String> finalStrings = strings.subList(0, Math.min(10, strings.size()));
		assertThat(finalStrings.size(), is(strings.size()));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSubListWithIndexOutOfBounds() {
		List<String> strings = new ArrayList<>();
		strings.add("test1");
		strings.add("test2");
		strings.subList(0, 10);
	}
	
}
