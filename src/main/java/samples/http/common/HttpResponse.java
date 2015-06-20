package samples.http.common;

import static samples.http.common.HttpConstants.*;

import lombok.Data;

import java.util.Map;

/**
 * Created by izeye on 15. 6. 20..
 */
@Data
public class HttpResponse {

	private final String statusLine;
	private final HttpStatus status;
	private final Map<String, String> headers;
	private final String body;

	public HttpResponse(String statusLine, Map<String, String> headers, String body) {
		this.statusLine = statusLine;
		String[] statusFields = statusLine.split(DELIMITER_SPACE);
		String httpVersion = statusFields[0];
		if (!httpVersion.equals(HTTP_VERSION_1_1)) {
			throw new IllegalArgumentException("Unexpected HTTP version: " + httpVersion);
		}
		this.status = HttpStatus.valueOf(Integer.parseInt(statusFields[1]));
		this.headers = headers;
		this.body = body;
	}
	
}
