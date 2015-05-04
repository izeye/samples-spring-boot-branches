package samples.springboot.repository;

import samples.springboot.domain.ComplexPerson;
import samples.springboot.domain.Person;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
public interface PersonRepository {

	List<Person> findAll();
	
	List<ComplexPerson> findAllComplexPersonsWithResultType();

	List<ComplexPerson> findAllComplexPersonsWithResultMap();

	List<ComplexPerson> findAllComplexPersonsWithResultMapAndAssociation();

}
