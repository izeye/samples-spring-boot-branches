package samples.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by izeye on 15. 1. 31..
 */
@SpringBootApplication
public class Application {

	@Bean
	public MessageSource customMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("test/test");
		return messageSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
