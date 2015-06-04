package learningtest.org.junit.runners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by izeye on 15. 6. 5..
 */
@RunWith(Suite.class)
@SuiteClasses({AppleTests.class, BananaTests.class})
public class SuiteTests {
}
