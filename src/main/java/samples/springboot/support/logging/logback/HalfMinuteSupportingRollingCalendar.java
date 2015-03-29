package samples.springboot.support.logging.logback;

import ch.qos.logback.core.rolling.helper.RollingCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by izeye on 15. 3. 29..
 */
public class HalfMinuteSupportingRollingCalendar extends RollingCalendar {
	
	private static final long MILLIS_IN_HALF_MINUTE = TimeUnit.SECONDS.toMillis(30);

	@Override
	public long periodsElapsed(long start, long end) {
		return (end - start) / MILLIS_IN_HALF_MINUTE;
	}

	@Override
	public Date getRelativeDate(Date now, int periods) {
		this.setTime(now);

		this.set(Calendar.SECOND, this.get(Calendar.SECOND) < 30 ? 0 : 30);
		this.set(Calendar.MILLISECOND, 0);
		
		this.add(Calendar.SECOND, periods * 30);

		return this.getTime();
	}
	
}
