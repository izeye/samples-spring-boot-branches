package samples.springboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

/**
 * Created by izeye on 15. 3. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("dummy")
@IntegrationTest("spring.cache.type=simple")
public class PersonRepositoryTests {
	
	@Autowired
	PersonRepository personRepository;
	
	@Test
	public void testCache() {
		Long id = 1L;
		assertThat(personRepository.findOne(id),
				is(sameInstance(personRepository.findOne(id))));
	}

	@Test
	public void testCacheDuplicate() {
		Long id = 1L;
		assertThat(personRepository.findOne(id),
				is(sameInstance(personRepository.findOne(id))));
	}
	
}
