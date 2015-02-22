package samples.springboot.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import samples.springboot.domain.Person;

import java.util.List;

/**
 * Created by izeye on 15. 2. 22..
 */
@Repository
public class MyBatisPersonRepository implements PersonRepository {

	@Autowired
//	@Lazy
	private SqlSession sqlSession;

	@Override
	public List<Person> findAll() {
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		return mapper.findAll();
	}

}
