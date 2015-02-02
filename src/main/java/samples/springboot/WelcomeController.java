package samples.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by izeye on 15. 1. 31..
 */
@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String message;

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("time", new Date());
		model.addAttribute("message", this.message);
		return "welcome";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

}
