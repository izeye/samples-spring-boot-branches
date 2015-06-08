package samples.springboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;
import samples.springboot.domain.Customer;

/**
 * Created by izeye on 15. 6. 8..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerRepositoryTests {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void test() {
		customerRepository.deleteAll();
		
		customerRepository.save(new Customer("Alice", "Smith"));
		customerRepository.save(new Customer("Bob", "Smith"));

		System.out.println("Customers found with findAll():");
		System.out.println("-----");
		customerRepository.findAll().stream().forEach(System.out::println);
		System.out.println();

		System.out.println("Customer found with findByFirstName");
		System.out.println("-----");
		System.out.println(customerRepository.findByFirstName("Alice"));

		System.out.println("Customer found with findByLastName");
		System.out.println("-----");
		customerRepository.findByLastName("Smith").stream().forEach(System.out::println);
	}
	
}
