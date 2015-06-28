package samples.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.TraceRepositoryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.TraceWebFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by izeye on 15. 1. 31..
 */
@SpringBootApplication(exclude = {
	TraceRepositoryAutoConfiguration.class,
	TraceWebFilterAutoConfiguration.class
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
