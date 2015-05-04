package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.domain.ComplexPerson;
import samples.springboot.domain.Person;
import samples.springboot.repository.PersonRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 2. 22..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTests {

	@Autowired
	PersonRepository personRepository;

	@Test
	public void testFindAll() {
		List<Person> persons = personRepository.findAll();
		System.out.println(persons);
		assertThat(persons.size(), is(2));
	}

	@Test
	public void testFindAllComplexPersonsWithResultType() {
		List<ComplexPerson> persons = personRepository.findAllComplexPersonsWithResultType();
		System.out.println(persons);
		assertThat(persons.size(), is(2));
	}

	@Test
	public void testFindAllComplexPersonsWithResultMap() {
		List<ComplexPerson> persons = personRepository.findAllComplexPersonsWithResultMap();
		System.out.println(persons);
		assertThat(persons.size(), is(2));
	}

	@Test
	public void testFindAllComplexPersonsWithResultMapAndAssociation() {
		List<ComplexPerson> persons = personRepository.findAllComplexPersonsWithResultMapAndAssociation();
		System.out.println(persons);
		// Should work?
//		assertThat(persons.size(), is(2));
	}

}
