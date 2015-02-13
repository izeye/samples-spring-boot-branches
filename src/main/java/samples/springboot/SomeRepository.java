package samples.springboot;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by izeye on 15. 2. 11..
 */
@Repository
public class SomeRepository {

	@PostConstruct
	public void postConstruct() {
		System.out.println(getClass().getSimpleName() + ": @PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println(getClass().getSimpleName() + ": @PreDestroy");
	}

}
