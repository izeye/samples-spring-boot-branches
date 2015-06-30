package samples.springboot.counter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by izeye on 15. 6. 30..
 */
@RestController
@RequestMapping("/counter")
public class CounterController {
	
	@Autowired
	private CounterService counterService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void count() {
		counterService.increment("test");
	}
	
}
