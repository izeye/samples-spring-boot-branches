package samples.springboot.server.repository;

import samples.springboot.server.domain.Server;

/**
 * Created by izeye on 15. 3. 23..
 */
public class DummyFactory {

	public static Server getServer() {
		String hostname = "izeye";
		String ipAddress = "1.2.3.4";

		Server server = new Server();
		server.setHostname(hostname);
		server.setIpAddress(ipAddress);
		return server;
	}

}
