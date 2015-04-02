package samples.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by izeye on 15. 2. 27..
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(@Param("lastName") String lastName);
	
	List<Customer> findByLastNameNotLike(@Param("lastName") String lastName);

}
