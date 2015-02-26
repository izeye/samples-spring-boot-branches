package samples.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Created by izeye on 15. 2. 27..
 */
@ConfigurationProperties(prefix = "my.app")
public class MyAppProperties {

	private Map<String, String> someValues;

	public Map<String, String> getSomeValues() {
		return someValues;
	}

	public void setSomeValues(Map<String, String> someValues) {
		this.someValues = someValues;
	}

}
