package samples.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Created by izeye on 15. 2. 27..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class CustomerRepositoryTests {

	@Autowired
	CustomerRepository repository;
	
//	@Before
	public void setUp() {
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
	}

	@Test
	public void test() {
		Iterable<Customer> customers = repository.findAll();
		System.out.println("Customers found with findAll():");
		System.out.println("-----");
		customers.forEach(System.out::println);
		System.out.println();

		Customer customer = repository.findOne(1L);
		System.out.println("Customer found with findOne(1L):");
		System.out.println("-----");
		System.out.println(customer);
		System.out.println();

		List<Customer> bauers = repository.findByLastName("Bauer");
		System.out.println("Customer found with findByLastName('Bauer'):");
		System.out.println("-----");
		bauers.forEach(System.out::println);
	}
	
	@Test
	public void testFindByLastNameNotLike() {
		List<Customer> customers = repository.findByLastNameNotLike("B%");
		customers.forEach(System.out::println);
		
		customers.forEach(customer -> assertThat(customer.getLastName(), not(startsWith("B"))));
	}

}
