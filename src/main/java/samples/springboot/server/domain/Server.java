package samples.springboot.server.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by izeye on 15. 3. 23..
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "latestStatus")
public class Server {

	@Id
	@GeneratedValue
	private Long id;

	private String hostname;
	private String ipAddress;

	@OneToOne
	@JoinColumn(name = "lastest_status_id")
	private ServerStatus latestStatus;

}
