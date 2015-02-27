package samples.springboot;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by izeye on 15. 2. 27..
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

}
