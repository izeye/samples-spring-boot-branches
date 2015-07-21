package learningtest.sun.net.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.net.util.IPAddressUtil;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by izeye on 15. 7. 21..
 */
public class IPAddressUtilTests {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testIsIPv4LiteralAddress() {
		assertTrue(IPAddressUtil.isIPv4LiteralAddress("1.2.3.0"));
		assertTrue(IPAddressUtil.isIPv4LiteralAddress("1.2.3.4"));
		assertTrue(IPAddressUtil.isIPv4LiteralAddress("1.2.3.255"));
		assertFalse(IPAddressUtil.isIPv4LiteralAddress("1.2.3.256"));
		assertFalse(IPAddressUtil.isIPv4LiteralAddress("1.2.3."));
		
		// NOTE: They look weird but valid.
		// See http://stackoverflow.com/questions/7550806/check-valid-ipv4-address-in-java
		assertTrue(IPAddressUtil.isIPv4LiteralAddress("1.2.3"));
		assertTrue(IPAddressUtil.isIPv4LiteralAddress("1.2"));
		assertTrue(IPAddressUtil.isIPv4LiteralAddress("1"));
		
		assertFalse(IPAddressUtil.isIPv4LiteralAddress(""));
		assertFalse(IPAddressUtil.isIPv4LiteralAddress("::1"));
		
		thrown.expect(NullPointerException.class);
		assertFalse(IPAddressUtil.isIPv4LiteralAddress(null));
	}
	
	@Test
	public void testIsIPv6LiteralAddress() {
		assertTrue(IPAddressUtil.isIPv6LiteralAddress("::1"));
		assertFalse(IPAddressUtil.isIPv6LiteralAddress("1.2.3.4"));
	}
	
}
