package samples.springboot.person.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import samples.springboot.person.domain.Person;

/**
 * Created by izeye on 15. 6. 29..
 */
@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void add(@RequestBody Person person) {
		System.out.println(person);
	}
	
}
