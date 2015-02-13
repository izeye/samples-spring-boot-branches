package samples.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by izeye on 15. 1. 31..
 */
@SpringBootApplication
public class Application {

	@Bean
	public ApplicationListener<ApplicationEvent> applicationListener() {
		return new ApplicationListener<ApplicationEvent>() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				System.out.println("ApplicationEvent: " + event.getClass().getSimpleName());
			}
		};
	}

	@Bean
	public ApplicationListener<EmbeddedServletContainerInitializedEvent> applicationListenerForStarted() {
		return new ApplicationListener<EmbeddedServletContainerInitializedEvent>() {
			@Override
			public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
				System.out.println("EmbeddedServletContainerInitializedEvent: "
						+ event.getClass().getSimpleName());
			}
		};
	}

	@Bean
	public ApplicationListener<ContextClosedEvent> applicationListenerForStopped() {
		return new ApplicationListener<ContextClosedEvent>() {
			@Override
			public void onApplicationEvent(ContextClosedEvent event) {
				System.out.println("ContextClosedEvent: " + event.getClass().getSimpleName());
			}
		};
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println(getClass().getSimpleName() + ": @PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println(getClass().getSimpleName() + ": @PreDestroy");
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.addListeners(new ApplicationListener<SpringApplicationEvent>() {
			@Override
			public void onApplicationEvent(SpringApplicationEvent event) {
				System.out.println("SpringApplicationEvent: " + event.getClass().getSimpleName());
			}
		});
		application.run(args);
	}

}
