package samples.springboot.server.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import samples.springboot.Application;
import samples.springboot.server.domain.Server;
import samples.springboot.server.domain.ServerStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Created by izeye on 15. 3. 23..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ServerStatusRepositoryTests {

	@Autowired
	ServerStatusRepository serverStatusRepository;

	@Autowired
	ServerRepository serverRepository;

	@Test
	public void test() {
		Server server = DummyFactory.getServer();
		serverRepository.save(server);

		ServerStatus newServerStatus = new ServerStatus();
		newServerStatus.setServer(server);
		newServerStatus.setAlive(true);
		ServerStatus saved = serverStatusRepository.save(newServerStatus);

		serverStatusRepository.findAll().stream().forEach(
				serverStatus -> System.out.println(serverStatus));

		ServerStatus found = serverStatusRepository.findOne(saved.getId());
		assertThat(found.getServer(), is(newServerStatus.getServer()));
		assertThat(found.isAlive(), is(newServerStatus.isAlive()));
		assertThat(found.getCollectedTime(), is(not(nullValue())));
	}

}
