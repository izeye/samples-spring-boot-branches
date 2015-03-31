package samples.springboot.repository;

import samples.springboot.domain.Person;

/**
 * Created by izeye on 15. 3. 31..
 */
public interface PersonRepository {
	
	Person findOne(Long id);
	
}
