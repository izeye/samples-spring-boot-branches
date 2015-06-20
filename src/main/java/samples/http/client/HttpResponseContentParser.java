package samples.http.client;

import samples.http.common.HttpResponse;

/**
 * Created by izeye on 15. 6. 20..
 */
public interface HttpResponseContentParser {
	
	HttpResponse parse(byte[] bytes);
	
}
