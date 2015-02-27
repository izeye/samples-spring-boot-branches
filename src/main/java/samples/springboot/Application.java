package samples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Created by izeye on 15. 1. 31..
 */
@SpringBootApplication
public class Application {

	@Autowired
	private CustomerRepository repository;

	@PostConstruct
	protected void init() {
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);
	}

}
