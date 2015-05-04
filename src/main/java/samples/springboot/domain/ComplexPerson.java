package samples.springboot.domain;

import lombok.Data;

/**
 * Created by izeye on 15. 5. 4..
 */
@Data
public class ComplexPerson {

	private Long id;
	private PersonName name;
	private int age;
	
}
