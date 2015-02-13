package samples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by izeye on 15. 2. 11..
 */
@RestController
public class SomeController {

	@Autowired
	private SomeService someService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Hello, world!";
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println(getClass().getSimpleName() + ": @PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println(getClass().getSimpleName() + ": @PreDestroy");
	}

}
