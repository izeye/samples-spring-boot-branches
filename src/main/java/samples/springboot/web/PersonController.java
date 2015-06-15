package samples.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import samples.springboot.domain.Person;
import samples.springboot.repository.PersonRepository;

/**
 * Created by izeye on 15. 6. 15..
 */
@Controller
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Person get(@RequestParam Long id) {
		return personRepository.findOne(id);
	}
	
}
