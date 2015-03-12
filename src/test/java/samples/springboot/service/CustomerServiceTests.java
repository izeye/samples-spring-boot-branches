package samples.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;
import samples.springboot.domain.Customer;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by izeye on 15. 3. 12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerServiceTests {

	@Autowired
	CustomerService customerService;

	@Test
	public void test() {
		String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
		for (String fullname : names) {
			String[] name = fullname.split(" ");
			System.out.printf("Inserting customer record for %s %s\n", name[0], name[1]);
			customerService.save(new Customer(name[0], name[1]));
		}

		System.out.println("Querying for customer records where first_name = 'Josh':");
		List<Customer> results = customerService.findByFirstName("Josh");
		for (Customer customer : results) {
			System.out.println(customer);
		}

		System.out.println("Querying for all customer records:");
		results = customerService.findAll();
		for (Customer customer : results) {
			System.out.println(customer);
		}

		System.out.println(customerService.getClass().getName());
		assertThat(customerService, is(not(instanceOf(DefaultCustomerService.class))));
	}

}
