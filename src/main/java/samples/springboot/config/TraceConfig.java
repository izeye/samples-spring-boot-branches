package samples.springboot.config;

import org.springframework.boot.actuate.autoconfigure.TraceRepositoryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.TraceWebFilterAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Created by izeye on 15. 6. 28..
 */
@Configuration
@Profile("trace")
@Import({
		TraceRepositoryAutoConfiguration.class,
		TraceWebFilterAutoConfiguration.class
})
public class TraceConfig {
}
