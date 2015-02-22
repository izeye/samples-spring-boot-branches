package samples.springboot.repository;

import samples.springboot.domain.Customer;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
public interface CustomerRepository {

	void save(Customer customer);

	List<Customer> findAll();

	List<Customer> findByFirstName(String firstName);

}
