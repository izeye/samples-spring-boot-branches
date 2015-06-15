package samples.springboot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import samples.springboot.repository.PersonRepositoryTests;

/**
 * Created by izeye on 15. 6. 15..
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ApplicationTests.class, PersonRepositoryTests.class})
public class IntegrationTests {
}
