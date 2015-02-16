package samples.springboot;

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

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("name", "Johnny");
		return "index";
	}

}
