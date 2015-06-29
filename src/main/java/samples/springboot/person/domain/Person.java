package samples.springboot.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by izeye on 15. 6. 29..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	private long id;
	private String name;
	
}
