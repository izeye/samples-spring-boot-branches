package learningtest.java.lang;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by izeye on 15. 4. 2..
 */
public class ClassTests {
	
	@Test
	public void test() {
		Class clazz = getClass();
		System.out.println(clazz.toString());
		System.out.println(clazz.getCanonicalName());
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getTypeName());
	}
	
	@Test
	public void testGetResourceAsStream() throws IOException {
		InputStream is = getClass().getResourceAsStream("/data/keywords.txt");
		String string = IOUtils.toString(is);
		assertThat(string, is("Hello, \nworld!\n"));
	}
	
}
