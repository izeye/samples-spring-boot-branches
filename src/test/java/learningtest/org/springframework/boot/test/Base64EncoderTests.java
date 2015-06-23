package learningtest.org.springframework.boot.test;

import org.junit.Test;

import java.util.Base64;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by izeye on 15. 6. 24..
 */
public class Base64EncoderTests {
	
	private static final String TEXT = "Man is distinguished, not only by his reason, "
		+ "but by this singular passion from other animals, which is a lust of the "
		+ "mind, that by a perseverance of delight in the continued and indefatigable "
		+ "generation of knowledge, exceeds the short vehemence of any carnal pleasure.";

	private static final String ENCODED = "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5I"
			+ "GhpcyByZWFzb24sIGJ1dCBieSB0aGlzIHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbm"
			+ "ltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2YgdGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmF"
			+ "uY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGludWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVy"
			+ "YXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRoZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55I"
			+ "GNhcm5hbCBwbGVhc3VyZS4=";

	@Test
	public void encodeText() {
		assertThat(Base64Encoder.encode(TEXT), equalTo(ENCODED));
		assertThat(Base64Encoder.encode("pleasure."), equalTo("cGxlYXN1cmUu"));
		assertThat(Base64Encoder.encode("leasure."), equalTo("bGVhc3VyZS4="));
		assertThat(Base64Encoder.encode("easure."), equalTo("ZWFzdXJlLg=="));
		assertThat(Base64Encoder.encode("asure."), equalTo("YXN1cmUu"));
		assertThat(Base64Encoder.encode("sure."), equalTo("c3VyZS4="));
	}
	
	@Test
	public void encodeTestWithJavaUtilBase64Encoder() {
		assertThat(encodeByJavaUtilBase64Encoder(TEXT), equalTo(ENCODED));
		assertThat(encodeByJavaUtilBase64Encoder("pleasure."), equalTo("cGxlYXN1cmUu"));
		assertThat(encodeByJavaUtilBase64Encoder("leasure."), equalTo("bGVhc3VyZS4="));
		assertThat(encodeByJavaUtilBase64Encoder("easure."), equalTo("ZWFzdXJlLg=="));
		assertThat(encodeByJavaUtilBase64Encoder("asure."), equalTo("YXN1cmUu"));
		assertThat(encodeByJavaUtilBase64Encoder("sure."), equalTo("c3VyZS4="));
	}

	private final Base64.Encoder javaUtilBase64Encoder = Base64.getEncoder();
	
	private String encodeByJavaUtilBase64Encoder(String value) {
		return new String(javaUtilBase64Encoder.encode(value.getBytes()));
	}
	
}
