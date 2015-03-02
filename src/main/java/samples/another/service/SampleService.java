package samples.another.service;

import org.springframework.stereotype.Component;

/**
 * Created by izeye on 15. 3. 2..
 */
public class SampleService {

	private String value;

	public SampleService(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "SampleService{" +
				"value='" + value + '\'' +
				'}';
	}

}
