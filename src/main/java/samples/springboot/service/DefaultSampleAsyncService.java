package samples.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by izeye on 15. 3. 21..
 */
@Service
public class DefaultSampleAsyncService implements SampleAsyncService {

	@Override
	@Async
	public Future<String> echoWithDelayInMillis(String text, long delayInMillis) {
		System.out.println(Thread.currentThread());
		
		try {
			Thread.sleep(delayInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AsyncResult<>(text);
	}

	@Override
	public Future<String> invokeEchoWithDelayInMillisInternally(String text, long delayInMillis) {
		return echoWithDelayInMillis(text, delayInMillis);
	}

}
