package samples.http.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by izeye on 15. 6. 20..
 */
@Data
public class HttpRequest {

	private final String server;
	private final int port;
	private final HttpMethod method;
	private final String path;

	private final Map<String, Object> headers = new HashMap<>();
	private final Map<String, Object> parameters = new HashMap<>();

	public HttpRequest(String server, int port, HttpMethod method, String path) {
		this.server = server;
		this.port = port;
		this.path = path;
		this.method = method;
	}

	public void addHeader(String name, Object value) {
		this.headers.put(name, value);
	}

	public void addParameter(String name, Object value) {
		this.parameters.put(name, value);
	}
	
}
