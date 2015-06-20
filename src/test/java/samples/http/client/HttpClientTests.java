package samples.http.client;

import org.junit.Before;
import org.junit.Test;
import samples.http.common.HttpMethod;
import samples.http.common.HttpRequest;
import samples.http.common.HttpResponse;

/**
 * Created by izeye on 15. 6. 20..
 */
public class HttpClientTests {
	
	HttpClient httpClient;
	
	@Before
	public void setUp() {
		this.httpClient = new SimpleHttpClient();
	}
	
	@Test
	public void testSend() {
		String server = "www.naver.com";
		int port = 80;
		HttpMethod method = HttpMethod.GET;
		String path = "/";
		HttpRequest request = new HttpRequest(server, port, method, path);
		HttpResponse response = this.httpClient.send(request);
		System.out.println(response);
	}
	
}
