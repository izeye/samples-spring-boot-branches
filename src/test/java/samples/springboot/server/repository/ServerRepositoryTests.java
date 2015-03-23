package samples.springboot.server.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;
import samples.springboot.server.domain.Server;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 3. 23..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ServerRepositoryTests {

	@Autowired
	ServerRepository serverRepository;

	@Test
	public void test() {
		Server newServer = DummyFactory.getServer();
		Server saved = serverRepository.save(newServer);

		serverRepository.findAll().stream().forEach(server -> System.out.println(server));

		Server found = serverRepository.findOne(saved.getId());
		assertThat(found.getHostname(), is(newServer.getHostname()));
		assertThat(found.getIpAddress(), is(newServer.getIpAddress()));
	}

}
