package samples.springboot;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by izeye on 15. 7. 19..
 */
@Document(indexName = "id")
@Data
public class Person {
	
	private String id;
	private String name;
	
}
