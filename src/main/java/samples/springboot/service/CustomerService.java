package samples.springboot.service;

import samples.springboot.domain.Customer;

import java.util.List;

/**
 * Created by izeye on 15. 3. 12..
 */
public interface CustomerService {

	void save(Customer customer);

	List<Customer> findAll();

	List<Customer> findByFirstName(String firstName);

}
