package samples.http.client;

import static samples.http.common.HttpConstants.*;

import samples.http.common.HttpRequest;
import samples.http.common.HttpResponse;
import samples.http.util.IoUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by izeye on 15. 6. 20..
 */
public class SimpleHttpClient implements HttpClient {
	
	private final DefaultHttpRequestContentBuilder requestContentBuilder
			= new DefaultHttpRequestContentBuilder();
	private final HttpResponseContentParser responseContentParser
			= new DefaultHttpResponseContentParser();

	@Override
	public HttpResponse send(HttpRequest request) {
		String server = request.getServer();
		int port = request.getPort();

		Map<String, Object> headers = request.getHeaders();

		addHostHeaderIfNotExist(server, port, headers);

		try (
				Socket socket = new Socket(server, port);
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream()) {
			String requestContent = requestContentBuilder.build(request);
			os.write(requestContent.getBytes());
			os.flush();

			return responseContentParser.parse(IoUtils.toByteArray(is));
		} catch (UnknownHostException ex) {
			throw new RuntimeException(ex);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	// NOTE:
	// `Host` header is mandatory since HTTP 1.1.
	private void addHostHeaderIfNotExist(String server, int port, Map<String, Object> headers) {
		if (!headers.containsKey(HEADER_HOST)) {
			headers.put(HEADER_HOST, server + ":" + port);
		}
	}
	
}
