package learningtest.java.lang;

import org.junit.Test;

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
	
}
