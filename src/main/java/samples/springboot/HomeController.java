package samples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by izeye on 15. 2. 8..
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("name", "Johnny");
		return "index";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

}
