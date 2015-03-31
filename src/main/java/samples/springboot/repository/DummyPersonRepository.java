package samples.springboot.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import samples.springboot.domain.Person;

/**
 * Created by izeye on 15. 3. 31..
 */
@Repository
public class DummyPersonRepository implements PersonRepository {
	
	@Cacheable("persons")
	@Override
	public Person findOne(Long id) {
		return new Person(id, "Johnny", "Lim", 35);
	}
	
}
