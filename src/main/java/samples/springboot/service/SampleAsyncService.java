package samples.springboot.service;

import java.util.concurrent.Future;

/**
 * Created by izeye on 15. 3. 21..
 */
public interface SampleAsyncService {

	Future<String> echoWithDelayInMillis(String text, long delayInMillis);

	Future<String> invokeEchoWithDelayInMillisInternally(String text, long delayInMillis);

}
