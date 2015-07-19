package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * Created by izeye on 15. 7. 19..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTests {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	
	@Test
	public void testRepository() {
		Person person1 = new Person();
		person1.setId("1");
		person1.setName("Johnny");
		personRepository.save(person1);
		
		Person person2 = new Person();
		person2.setId("2");
		person2.setName("John");
		
		Person person3 = new Person();
		person3.setId("3");
		person3.setName("Alice");
		
		List<Person> persons = Arrays.asList(person2, person3);
		personRepository.save(persons);

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(queryStringQuery("1").field("id")).build();
		Page<Person> fetchedPersons = elasticsearchTemplate.queryForPage(searchQuery, Person.class);
		fetchedPersons.forEach(System.out::println);
	}

	@Test
	public void testElasticsearchTemplate() {
		Person person1 = new Person();
		person1.setId("1");
		person1.setName("Johnny");
		IndexQuery indexQuery1 = new IndexQueryBuilder().withId(person1.getId()).withObject(person1).build();
		elasticsearchTemplate.index(indexQuery1);

		Person person2 = new Person();
		person2.setId("2");
		person2.setName("John");

		Person person3 = new Person();
		person3.setId("3");
		person3.setName("Alice");
		
		IndexQuery indexQuery2 = new IndexQueryBuilder().withId(person2.getId()).withObject(person2).build();
		IndexQuery indexQuery3 = new IndexQueryBuilder().withId(person3.getId()).withObject(person3).build();

		List<IndexQuery> indexQueries = Arrays.asList(indexQuery2, indexQuery3);
		elasticsearchTemplate.bulkIndex(indexQueries);

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(queryStringQuery("2").field("id")).build();
		Page<Person> fetchedPersons = elasticsearchTemplate.queryForPage(searchQuery, Person.class);
		fetchedPersons.forEach(System.out::println);
	}
	
}
