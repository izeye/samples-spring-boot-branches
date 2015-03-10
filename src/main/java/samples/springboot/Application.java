package samples.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by izeye on 15. 1. 31..
 */
@SpringBootApplication
public class Application {

	@Bean
	public ApplicationPidFileWriter applicationPidFileWriter() {
		return new ApplicationPidFileWriter();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
