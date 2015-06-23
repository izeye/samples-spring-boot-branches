package learningtest.org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 6. 23..
 */
public class URLCodecTests {
	
	URLCodec urlCodec;
	
	@Before
	public void setUp() {
		this.urlCodec = new URLCodec();
	}
	
	@Test
	public void testEncode() throws EncoderException {
		String value = "1-1";
		assertThat(this.urlCodec.encode(value), is(value));
	}
	
	@Test
	public void testDecode() throws DecoderException {
		String decoded = "1-1";
		
		String encoded = "1-1";
		assertThat(this.urlCodec.decode(encoded), is(decoded));

		// NOTE: This is a discouraged encoding because `-` is not a reserved character.
		// https://en.wikipedia.org/wiki/Percent-encoding
		encoded = "1%2D1";
		assertThat(this.urlCodec.decode(encoded), is(decoded));
	}
	
}
