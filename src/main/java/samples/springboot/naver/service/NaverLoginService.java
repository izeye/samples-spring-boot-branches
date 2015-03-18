package samples.springboot.naver.service;

/**
 * Created by izeye on 15. 3. 18..
 */
public interface NaverLoginService {

	String getAuthenticationRequestUrl(String stateToken);

	String getUserId(String stateToken, String authorizationCode);

}
