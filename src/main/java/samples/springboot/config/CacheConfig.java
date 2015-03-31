package samples.springboot.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by izeye on 15. 3. 31..
 */
@Configuration
@EnableCaching
public class CacheConfig {
	
	@Bean
	public CacheManager cacheManager(net.sf.ehcache.CacheManager cacheManager) {
		return new EhCacheCacheManager(cacheManager);
	}

	@Bean
	public EhCacheManagerFactoryBean ehcache() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache/ehcache.xml"));
		return ehCacheManagerFactoryBean;
	}
	
}
