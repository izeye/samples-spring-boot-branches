package samples.springboot.naver.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by izeye on 15. 3. 18..
 */
@ConfigurationProperties(prefix = "naver.login")
@Data
public class NaverLoginProperties {

	private String clientId;
	private String clientSecret;
	private String redirectUri;

}
