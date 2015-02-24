package samples.springboot;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by izeye on 15. 2. 24..
 */
@Component
@Path("/hello")
public class Endpoint {

	@GET
	public String message() {
		return "Hello";
	}

}
