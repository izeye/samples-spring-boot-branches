package samples.springboot;

import ch.qos.logback.access.servlet.TeeFilter;
import ch.qos.logback.access.tomcat.LogbackValve;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 15. 2. 25..
 */
@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean teeFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new TeeFilter());
		return filterRegistrationBean;
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				if (container instanceof TomcatEmbeddedServletContainerFactory) {
					TomcatEmbeddedServletContainerFactory containerFactory =
							(TomcatEmbeddedServletContainerFactory) container;

					LogbackValve logbackValve = new LogbackValve();
					logbackValve.setFilename("src/main/resources/logback-access.xml");

					containerFactory.addContextValves(logbackValve);
				}
			}
		};
	}

}
