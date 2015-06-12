package learningtest.net.sf.ehcache.management;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.junit.Ignore;
import org.junit.Test;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

/**
 * Created by izeye on 15. 6. 12..
 */
public class ManagementServiceTests {
	
	@Ignore
	@Test
	public void testRegisterMBeans() {
		CacheManager manager = new CacheManager();
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		ManagementService.registerMBeans(manager, mBeanServer, true, true, true, true);
		
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
