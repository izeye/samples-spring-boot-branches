package samples.springboot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by izeye on 15. 3. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	AnnotationConfigApplicationContext context;

	@After
	public void tearDown() {
		this.context.close();
	}

	@Test
	public void test() {
		// To test JMX.
//		try {
//			Thread.sleep(Long.MAX_VALUE);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}
