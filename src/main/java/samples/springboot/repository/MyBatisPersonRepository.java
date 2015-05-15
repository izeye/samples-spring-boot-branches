package samples.springboot.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import samples.springboot.domain.ComplexPerson;
import samples.springboot.domain.Person;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
@Repository
public class MyBatisPersonRepository implements PersonRepository {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Person> findAll() {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		return mapper.findAll();
	}

	@Override
	public List<ComplexPerson> findAllComplexPersonsWithResultType() {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		return mapper.findAllComplexPersonsWithResultType();
	}

	@Override
	public List<ComplexPerson> findAllComplexPersonsWithResultMap() {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		return mapper.findAllComplexPersonsWithResultMap();
	}

	@Override
	public List<ComplexPerson> findAllComplexPersonsWithResultMapHavingIdAndAssociation() {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		return mapper.findAllComplexPersonsWithResultMapHavingIdAndAssociation();
	}

	@Override
	public List<ComplexPerson> findAllComplexPersonsWithResultMapHavingResultAndAssociation() {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		return mapper.findAllComplexPersonsWithResultMapHavingResultAndAssociation();
	}

}
