package samples.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.restdocs.RestDocumentation.document;
import static org.springframework.restdocs.RestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.LinkExtractors.halLinks;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by izeye on 15. 7. 27..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SpringRestDocsTests {
	
	@Autowired
	WebApplicationContext context;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration()).build();
	}
	
	@Test
	public void index() throws Exception {
		this.mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(document("index"));
	}

	@Test
	public void api() throws Exception {
		this.mockMvc.perform(get("/api").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("_links.customers", is(notNullValue())))
				.andDo(document("api").withLinks(halLinks(),
						linkWithRel("customers").description("Link to the customers"),
						linkWithRel("profile").description("Link to the profile")));
	}

	@Test
	public void customers() throws Exception {
		this.mockMvc.perform(get("/api/customers?page=0&size=20").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(document("customers")
						.withQueryParameters(
								parameterWithName("page").description("The page to retrieve"),
								parameterWithName("size").description("Entries per page"))
						.withLinks(halLinks(),
								linkWithRel("self").description("Link to self"),
								linkWithRel("search").description("Link to search"))
						.withResponseFields(
								fieldWithPath("_links").description("Links to other resources"),
								fieldWithPath("_embedded.customers").description("An array of Customer resources"),
								fieldWithPath("page").description("Page")));
	}
	
}
