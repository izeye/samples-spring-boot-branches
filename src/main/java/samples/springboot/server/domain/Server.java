package samples.springboot.server.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by izeye on 15. 3. 23..
 */
@Entity
@Data
public class Server {

	@Id
	@GeneratedValue
	private Long id;

	private String hostname;
	private String ipAddress;

}
