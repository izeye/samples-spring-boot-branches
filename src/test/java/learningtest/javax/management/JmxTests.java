package learningtest.javax.management;

import org.junit.Ignore;
import org.junit.Test;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by izeye on 15. 5. 6..
 */
public class JmxTests {

	/**
	 * Run with the following VM options:
	 * -Dcom.sun.management.jmxremote.port=9999
	 * -Dcom.sun.management.jmxremote.authenticate=false
	 * -Dcom.sun.management.jmxremote.ssl=false
	 *
	 * @throws IOException
	 */
	@Test
	@Ignore
	public void test() throws IOException, MalformedObjectNameException, InstanceNotFoundException, MBeanException,
			AttributeNotFoundException, ReflectionException {
		echo("\nCreate an RMI connector client and "
				+ "connect it to the RMI connector server");
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
		JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

		echo("\nDomains:");
		String domains[] = mbsc.getDomains();
		Arrays.sort(domains);
		for (String domain : domains) {
			echo("\tDomain = " + domain);
		}

		echo("\nMBeanServer default domain = " + mbsc.getDefaultDomain());

		echo("\nMBean count = " +  mbsc.getMBeanCount());
		echo("\nQuery MBeanServer MBeans:");
		Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null, null));
		for (ObjectName name : names) {
			echo("\tObjectName = " + name);
		}

		ObjectName objectName = new ObjectName("java.lang:type=OperatingSystem");
		double systemLoadAverage = (double) mbsc.getAttribute(objectName, "SystemLoadAverage");
		System.out.println(systemLoadAverage);

		jmxc.close();
	}

	private void echo(String message) {
		System.out.println(message);
	}
	
}
