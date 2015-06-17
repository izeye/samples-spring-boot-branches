package learningtest.com.gargoylesoftware.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by izeye on 15. 6. 16..
 */
public class WebClientTests {
	
	@Test
	public void homePage() {
		try (WebClient webClient = new WebClient()) {
//			String expected = "HtmlUnit - Welcome to HtmlUnit";
			String expected = "HtmlUnit " + (char) 8211 + " Welcome to HtmlUnit";
			HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
			assertThat(page.getTitleText(), is(expected));

			String pageAsXml = page.asXml();
			assertThat(pageAsXml, containsString("<body class=\"composite\">"));

			String pageAsText = page.asText();
			assertThat(pageAsText, containsString("Support for the HTTP and HTTPS protocols"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
