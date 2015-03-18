package samples.springboot.naver.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by izeye on 15. 3. 18..
 */
public class NaverUtils {

	private static final int STATE_TOKEN_MAX_BIT_LENGTH = 130;
	private static final int STATE_TOKEN_RADIX = 32;

	private static final String DELIMITER_EMAIL = "@";
	private static final int INDEX_EMAIL_USER_ID = 0;

	private static final ThreadLocal<SecureRandom> RANDOM = new ThreadLocal<SecureRandom>() {
		@Override
		protected SecureRandom initialValue() {
			return new SecureRandom();
		}
	};

	public static String generateStateToken() {
		return new BigInteger(STATE_TOKEN_MAX_BIT_LENGTH, RANDOM.get())
				.toString(STATE_TOKEN_RADIX);
	}

	public static String getUserIdFromEmail(String email) {
		return email.split(DELIMITER_EMAIL)[INDEX_EMAIL_USER_ID];
	}

}
