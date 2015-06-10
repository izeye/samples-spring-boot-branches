package learningtest.org.junit.experimental.theories;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assume.assumeThat;

/**
 * Created by izeye on 15. 6. 10..
 */
@RunWith(Theories.class)
public class TheoriesTests {
	
	@DataPoint
	public static String GOOD_USERNAME = "optimus";
	
	@DataPoint
	public static String USERNAME_WITH_SLASH = "optimus/prime";
	
	@Theory
	public void filenameIncludesUsername(String username) {
		System.out.println("Before assumeThat: " + username);
		assumeThat(username, not(containsString("/")));
		System.out.println("After assumeThat: " + username);
		assertThat(username, is(GOOD_USERNAME));
	}
	
}
