package samples.springboot;

import io.github.robwin.markup.builder.MarkupLanguage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by izeye on 15. 7. 26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class Swagger2MarkupSpringfoxTests {
	
	@Autowired
	WebApplicationContext context;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void convertSwaggerToAsciiDoc() throws Exception {
		String urlTemplate = "/v2/api-docs";
		String outputDir = "src/docs/asciidoc/generated";
		
		this.mockMvc.perform(get(urlTemplate)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler
						.outputDirectory(outputDir).build())
				.andExpect(status().isOk());
	}

	@Test
	public void convertSwaggerToMarkdown() throws Exception {
		String urlTemplate = "/v2/api-docs";
		String outputDir = "src/docs/markdown/generated";

		this.mockMvc.perform(get(urlTemplate)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler.outputDirectory(outputDir)
						.withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
				.andExpect(status().isOk());
	}
	
}
