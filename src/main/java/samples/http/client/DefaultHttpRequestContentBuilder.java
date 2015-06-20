package samples.http.client;

import samples.http.common.HttpMethod;
import samples.http.common.HttpRequest;
import samples.http.util.HttpUtils;

import java.util.Map;

import static samples.http.common.HttpConstants.HTTP_VERSION_1_1;
import static samples.http.common.HttpConstants.NEW_LINE;

/**
 * Created by izeye on 15. 6. 20..
 */
public class DefaultHttpRequestContentBuilder implements HttpRequestContentBuilder {

	@Override
	public String build(HttpRequest request) {
		String startLine = buildStartLine(
				request.getMethod(), request.getPath(), request.getParameters());
		String headerLines = buildHeaderLines(request.getHeaders());
		return new StringBuilder(startLine).append(headerLines).append(NEW_LINE).toString();
	}

	private String buildStartLine(HttpMethod method, String path, Map<String, Object> parameters) {
		String query = HttpUtils.buildQuery(parameters);
		return String.format("%s %s?%s %s%s", method, path, query, HTTP_VERSION_1_1, NEW_LINE);
	}

	private String buildHeaderLines(Map<String, Object> headers) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Object> header : headers.entrySet()) {
			sb.append(buildHeaderLine(header.getKey(), header.getValue()));
		}
		return sb.toString();
	}

	private String buildHeaderLine(String name, Object value) {
		return String.format("%s: %s%s", name, value, NEW_LINE);
	}
	
}
