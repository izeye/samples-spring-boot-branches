package samples.http.client;

import samples.http.common.HttpRequest;

/**
 * Created by izeye on 15. 6. 20..
 */
public interface HttpRequestContentBuilder {

	String build(HttpRequest request);
	
}
