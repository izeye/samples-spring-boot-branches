package samples.springboot.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by izeye on 15. 6. 8..
 */
@Data
public class Customer {
	
	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	
	public Customer() {
	}
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
