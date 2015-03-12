package samples.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import samples.springboot.domain.Customer;
import samples.springboot.repository.CustomerRepository;

import java.util.List;

/**
 * Created by izeye on 15. 3. 12..
 */
@Service
public class DefaultCustomerService implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}

}
