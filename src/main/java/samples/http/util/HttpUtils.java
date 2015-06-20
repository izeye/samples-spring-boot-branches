package samples.http.util;

import java.util.Map;

import static samples.http.common.HttpConstants.*;

/**
 * Created by izeye on 15. 6. 20..
 */
public abstract class HttpUtils {

	public static String buildQuery(Map<String, Object> parameters) {
		StringBuilder sb = new StringBuilder();
		if (!parameters.isEmpty()) {
			for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
				sb.append(parameter.getKey());
				sb.append(DELIMITER_EQUALS);
				sb.append(UrlUtils.encode(parameter.getValue().toString()));
				sb.append(DELIMITER_AMPERSAND);
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
}
