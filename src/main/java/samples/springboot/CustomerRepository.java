package samples.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by izeye on 15. 2. 27..
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

}
