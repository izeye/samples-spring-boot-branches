package samples.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by izeye on 15. 2. 27..
 */
@ConfigurationProperties(prefix = "my.app")
public class MyAppProperties {

	private Map<String, String> someValues;
	
	private Class<?> clazz;
	
	private List<Class<?>> classes = new ArrayList<>();

	public Map<String, String> getSomeValues() {
		return someValues;
	}

	public void setSomeValues(Map<String, String> someValues) {
		this.someValues = someValues;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public List<Class<?>> getClasses() {
		return classes;
	}
	
}
