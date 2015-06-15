package samples.springboot.config;

import net.sf.ehcache.management.ManagementService;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import javax.management.MBeanServer;

/**
 * Created by izeye on 15. 3. 31..
 */
@Configuration
@EnableCaching
public class CacheConfig {
	
	@Bean
	public MBeanServerFactoryBean mBeanServer() {
		MBeanServerFactoryBean mBeanServerFactoryBean = new MBeanServerFactoryBean();
		mBeanServerFactoryBean.setLocateExistingServerIfPossible(true);
		return mBeanServerFactoryBean;
	}
	
	@Bean(initMethod = "init", destroyMethod = "dispose")
	public ManagementService managementService(
			net.sf.ehcache.CacheManager cacheManager, MBeanServer mBeanServer) {
		return new ManagementService(cacheManager, mBeanServer, true, true, true, true);
	}
	
}
