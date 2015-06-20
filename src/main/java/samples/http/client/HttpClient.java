package samples.http.client;

import samples.http.common.HttpRequest;
import samples.http.common.HttpResponse;

/**
 * Created by izeye on 15. 6. 20..
 */
public interface HttpClient {

	HttpResponse send(HttpRequest request);
	
}
