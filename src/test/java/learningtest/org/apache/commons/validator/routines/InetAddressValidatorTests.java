package learningtest.org.apache.commons.validator.routines;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by izeye on 15. 7. 21..
 */
public class InetAddressValidatorTests {
	
	InetAddressValidator validator = InetAddressValidator.getInstance();
	
	@Test
	public void testIsValidInet4Address() {
		assertTrue(validator.isValidInet4Address("1.2.3.0"));
		assertTrue(validator.isValidInet4Address("1.2.3.4"));
		assertTrue(validator.isValidInet4Address("1.2.3.255"));
		assertFalse(validator.isValidInet4Address("1.2.3.256"));
		assertFalse(validator.isValidInet4Address("1.2.3."));
		assertFalse(validator.isValidInet4Address("1.2.3"));
		assertFalse(validator.isValidInet4Address("1.2"));
		assertFalse(validator.isValidInet4Address("1"));
		assertFalse(validator.isValidInet4Address(""));
		assertFalse(validator.isValidInet4Address("::1"));
		assertFalse(validator.isValidInet4Address(null));
	}

	@Test
	public void testIsValidInet6Address() {
		assertTrue(validator.isValidInet6Address("::1"));
		assertFalse(validator.isValidInet6Address("1.2.3.4"));
	}

}
