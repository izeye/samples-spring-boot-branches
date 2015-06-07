package learningtest.com.squareup.okhttp;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by izeye on 15. 6. 7..
 */
public class OkHttpClientTests {

	OkHttpClient client;
	
	@Before
	public void setUp() {
		this.client = new OkHttpClient();
	}
	
	@Test
	public void test() {
		String url = "http://www.google.com";
		
		Request request = new Request.Builder()
				.url(url)
				.build();
		try {
			Response response = this.client.newCall(request).execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
