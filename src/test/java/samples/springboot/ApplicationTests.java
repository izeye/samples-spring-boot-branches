package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import samples.springboot.domain.Person;

/**
 * Created by izeye on 15. 3. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ApplicationTests {
	
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void test() {
		for (int i = 0; i < 20; i++) {
			restTemplate.getForObject("http://localhost:18080/persons?id=1", Person.class);
			String metrics = restTemplate.getForObject(
					"http://localhost:18080/management/metrics", String.class);
			System.out.println(metrics);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
