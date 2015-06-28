package samples.springboot.server;

import org.springframework.data.jpa.repository.JpaRepository;
import samples.springboot.customer.domain.Customer;

import java.util.List;

/**
 * Created by izeye on 15. 2. 27..
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

}
