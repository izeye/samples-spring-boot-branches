package samples.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import samples.springboot.domain.Customer;

import java.util.List;

/**
 * Created by izeye on 15. 6. 8..
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	Customer findByFirstName(String firstName);
	List<Customer> findByLastName(String lastName);
	
}
