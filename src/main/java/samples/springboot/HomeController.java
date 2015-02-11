package samples.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by izeye on 15. 2. 11..
 */
@RestController
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

}
