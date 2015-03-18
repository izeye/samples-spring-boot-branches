package samples.springboot.naver.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import samples.springboot.naver.util.NaverUtils;

/**
 * Created by izeye on 15. 3. 18..
 */
@Service
@EnableConfigurationProperties(NaverLoginProperties.class)
public class DefaultNaverLoginService implements NaverLoginService {

	private static final String TEMPLATE_AUTHENTICATION_REQUEST_URL
			= "https://nid.naver.com/oauth2.0/authorize?client_id=%s&response_type=code&redirect_uri=%s&state=%s";
	private static final String TEMPLATE_ACCESS_TOKEN_REQUEST_URL
			= "https://nid.naver.com/oauth2.0/token?client_id=%s&client_secret=%s&grant_type=authorization_code&state=%s&code=%s";

	private static final String USER_PROFILE_URL = "https://apis.naver.com/nidlogin/nid/getUserProfile.xml";

	private static final String HEADER_AUTHORIZATION = "Authorization";

	@Autowired
	private NaverLoginProperties naverLoginProperties;


	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public String getAuthenticationRequestUrl(String stateToken) {
		return String.format(TEMPLATE_AUTHENTICATION_REQUEST_URL,
				naverLoginProperties.getClientId(), naverLoginProperties.getRedirectUri(), stateToken);
	}

	@Override
	public String getUserId(String stateToken, String authorizationCode) {
		String accessTokenRequestUrl = String.format(
				TEMPLATE_ACCESS_TOKEN_REQUEST_URL,
				naverLoginProperties.getClientId(),
				naverLoginProperties.getClientSecret(), stateToken, authorizationCode);
		AccessTokenResponse accessTokenResponse = restTemplate.getForObject(
				accessTokenRequestUrl, AccessTokenResponse.class);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HEADER_AUTHORIZATION, "Bearer " + accessTokenResponse.getAccessToken());
		HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<UserProfileResponse> userProfileResponseEntity = restTemplate.exchange(
				USER_PROFILE_URL, HttpMethod.GET, requestEntity, UserProfileResponse.class);
		UserProfileResponse userProfileResponse = userProfileResponseEntity.getBody();
		String email = userProfileResponse.getResponse().getEmail();
		return NaverUtils.getUserIdFromEmail(email);
	}

	@Data
	static class AccessTokenResponse {
		@JsonProperty("access_token")
		private String accessToken;
		@JsonProperty("refresh_token")
		private String refreshToken;
		@JsonProperty("token_type")
		private String tokenType;
		@JsonProperty("expires_in")
		private int expiresIn;
	}

	@Data
	static class UserProfileResponse {
		private Response response;

		@Data
		static class Response {
			private String email;
		}
	}

}
