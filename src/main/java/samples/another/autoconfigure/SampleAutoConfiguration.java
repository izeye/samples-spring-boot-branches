package samples.another.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import samples.another.service.SampleService;

/**
 * Created by izeye on 15. 2. 28..
 */
@ConditionalOnMissingBean(SampleService.class)
@Configuration
@ComponentScan("samples.another.service")
public class SampleAutoConfiguration {
}
