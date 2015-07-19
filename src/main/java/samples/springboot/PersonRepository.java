package samples.springboot;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by izeye on 15. 7. 19..
 */
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
}
