package samples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by izeye on 15. 2. 11..
 */
@Service
public class SomeService {

	@Autowired
	private SomeRepository someRepository;

	@PostConstruct
	public void postConstruct() {
		System.out.println(getClass().getSimpleName() + ": @PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println(getClass().getSimpleName() + ": @PreDestroy");
	}

}
