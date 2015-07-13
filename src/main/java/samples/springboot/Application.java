package samples.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by izeye on 15. 1. 31..
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "server");
		
		SpringApplication application = new SpringApplication(Application.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
