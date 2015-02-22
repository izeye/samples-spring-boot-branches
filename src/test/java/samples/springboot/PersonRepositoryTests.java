package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.domain.Person;
import samples.springboot.repository.PersonRepository;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTests {

	@Autowired
	PersonRepository personRepository;

	@Test
	public void test() {
		List<Person> persons = personRepository.findAll();
		System.out.println(persons);
	}

}
