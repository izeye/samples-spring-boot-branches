package samples.springboot.support.logging.logback;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy;
import ch.qos.logback.core.rolling.RollingPolicyBase;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.rolling.helper.FileNamePattern;
import ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by izeye on 15. 3. 29..
 */
@NoAutoStart
public class HalfMinuteSupportingFNATP<E> extends DefaultTimeBasedFileNamingAndTriggeringPolicy<E> {

	private FileNamePattern fileNamePattern;
	private FileNamePattern fileNamePatternWCS;

	@Override
	public void start() {
		doHack();
		
		this.rc = new HalfMinuteSupportingRollingCalendar();

		setDateInCurrentPeriod(new Date(getCurrentTime()));
		addInfo("Setting initial period to " + dateInCurrentPeriod);
		computeNextCheck();

		archiveRemover = new TimeBasedArchiveRemover(this.fileNamePattern, this.rc);
		archiveRemover.setContext(context);
		
		this.started = true;
	}

	@Override
	public String getCurrentPeriodsFileNameWithoutCompressionSuffix() {
		return this.fileNamePatternWCS.convert(
				this.rc.getRelativeDate(dateInCurrentPeriod, 0));
	}

	private void doHack() {
		Field fileNamePatternField = ReflectionUtils.findField(
				RollingPolicyBase.class, "fileNamePattern");
		fileNamePatternField.setAccessible(true);
		this.fileNamePattern = (FileNamePattern) ReflectionUtils.getField(
				fileNamePatternField, this.tbrp);
		
		Field fileNamePatternWCSField = ReflectionUtils.findField(
				TimeBasedRollingPolicy.class, "fileNamePatternWCS");
		fileNamePatternWCSField.setAccessible(true);
		this.fileNamePatternWCS = (FileNamePattern) ReflectionUtils.getField(
				fileNamePatternWCSField, this.tbrp);
	}
	
}
