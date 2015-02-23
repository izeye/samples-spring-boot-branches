package samples.springboot;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by izeye on 15. 1. 31..
 */
@SpringBootApplication
@EnableAdminServer
public class Application {

	static {
		System.setProperty("spring.boot.admin.url", "http://localhost:18080");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
