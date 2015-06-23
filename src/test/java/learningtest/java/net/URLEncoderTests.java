package learningtest.java.net;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 23..
 */
public class URLEncoderTests {
	
	private static final String DEFAULT_ENCODING = "UTF-8";
	
	@Test
	public void testEncode() throws UnsupportedEncodingException {
		String value = "1-1";
		assertThat(URLEncoder.encode(value, DEFAULT_ENCODING), is(value));
	}

	@Test
	public void testDecode() throws UnsupportedEncodingException {
		String decoded = "1-1";

		String encoded = "1-1";
		assertThat(URLDecoder.decode(encoded, DEFAULT_ENCODING), is(decoded));

		// NOTE: This is a discouraged encoding because `-` is not a reserved character.
		// https://en.wikipedia.org/wiki/Percent-encoding
		encoded = "1%2D1";
		assertThat(URLDecoder.decode(encoded, DEFAULT_ENCODING), is(decoded));
	}
	
}
