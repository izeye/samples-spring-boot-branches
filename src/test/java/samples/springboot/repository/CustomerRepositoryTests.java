package samples.springboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;
import samples.springboot.domain.Customer;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerRepositoryTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void test() {
		String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
		for (String fullname : names) {
			String[] name = fullname.split(" ");
			System.out.printf("Inserting customer record for %s %s\n", name[0], name[1]);
			customerRepository.save(new Customer(name[0], name[1]));
		}

		System.out.println("Querying for customer records where first_name = 'Josh':");
		List<Customer> results = customerRepository.findByFirstName("Josh");
		for (Customer customer : results) {
			System.out.println(customer);
		}

		System.out.println("Querying for all customer records:");
		results = customerRepository.findAll();
		for (Customer customer : results) {
			System.out.println(customer);
		}
	}

}
