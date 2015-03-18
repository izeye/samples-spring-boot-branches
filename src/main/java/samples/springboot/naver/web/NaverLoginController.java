package samples.springboot.naver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import samples.springboot.naver.service.NaverLoginService;
import samples.springboot.naver.util.NaverUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by izeye on 15. 3. 18..
 */
@Controller
@RequestMapping("/test/naver_login")
public class NaverLoginController {

	private static final String SESSION_ATTRIBUTE_STATE_TOKEN = "stateToken";

	@Autowired
	private NaverLoginService naverLoginService;

	@RequestMapping(method = RequestMethod.GET)
	public String naverLogin(HttpServletRequest request, Model model) {
		String stateToken = NaverUtils.generateStateToken();
		request.getSession().setAttribute(SESSION_ATTRIBUTE_STATE_TOKEN, stateToken);

		String authenticationRequestUrl = naverLoginService.getAuthenticationRequestUrl(stateToken);
		model.addAttribute("authenticationRequestUrl", authenticationRequestUrl);
		return "test/naver_login";
	}

	@RequestMapping("/callback")
	@ResponseBody
	public String callback(@RequestParam String state, @RequestParam String code,
			HttpServletRequest request) {
		String stateTokenInSession
				= (String) request.getSession().getAttribute(SESSION_ATTRIBUTE_STATE_TOKEN);
		if (!state.equals(stateTokenInSession)) {
			throw new IllegalArgumentException(
					String.format(
							"Invalid state token: expected token is %s, but actual token was %s.",
							stateTokenInSession, state));
		}
		return naverLoginService.getUserId(state, code);
	}

}
