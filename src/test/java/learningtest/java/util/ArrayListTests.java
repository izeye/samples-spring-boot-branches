package learningtest.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	@Test
	public void testSubListClear() {
		List<Integer> integers = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
		
		List<Integer> subList = integers.subList(0, 3);
		assertThat(subList, is(Arrays.asList(1, 2, 3)));
		
		subList.clear();
		assertThat(integers, is(Arrays.asList(4, 5)));
	}
	
}
