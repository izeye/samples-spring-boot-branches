package samples.springboot;

import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 7. 24..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class Swagger2MarkupTests {
	
	@Value("${local.server.port}")
	int port;
	
	@Test
	public void convertRemoteSwaggerToAsciiDoc() throws IOException {
		String swaggerLocation = "http://localhost:" + port + "/v2/api-docs";
		String targetFolderPath = "src/docs/asciidoc/generated";

		Swagger2MarkupConverter.from(swaggerLocation).build()
				.intoFolder(targetFolderPath);
		
		String[] files = new File(targetFolderPath).list();
		assertThat(files.length, is(3));
		assertThat(files, is(new String[]{"definitions.adoc", "overview.adoc", "paths.adoc"}));
	}
	
	@Test
	public void convertRemoteSwaggerToMarkdown() throws IOException {
		String swaggerLocation = "http://localhost:" + port + "/v2/api-docs";
		String targetFolderPath = "src/docs/markdown/generated";
		
		Swagger2MarkupConverter.from(swaggerLocation)
				.withMarkupLanguage(MarkupLanguage.MARKDOWN).build()
				.intoFolder(targetFolderPath);

		String[] files = new File(targetFolderPath).list();
		assertThat(files.length, is(3));
		assertThat(files, is(new String[]{"definitions.md", "overview.md", "paths.md"}));
	} 
	
}
