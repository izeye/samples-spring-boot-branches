package samples.springboot.domain;

import lombok.Data;

/**
 * Created by izeye on 15. 2. 22..
 */
@Data
public class Person {

	private Long id;
	private String firstName;
	private String lastName;
	private int age;

}
