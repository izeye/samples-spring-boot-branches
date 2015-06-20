package samples.http.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by izeye on 15. 6. 20..
 */
public abstract class UrlUtils {

	private static final String DEFAULT_ENCODING = "UTF-8";

	public static String encode(String value) {
		try {
			return URLEncoder.encode(value, DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}
