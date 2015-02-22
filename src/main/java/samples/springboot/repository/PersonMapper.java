package samples.springboot.repository;

import samples.springboot.domain.Person;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
public interface PersonMapper {

	List<Person> findAll();

}
