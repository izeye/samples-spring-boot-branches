package samples.springboot.person.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import samples.springboot.person.domain.Person;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by izeye on 15. 6. 29..
 */
public class PersonControllerTests {

	final ObjectMapper mapper = new ObjectMapper();
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
	}
	
	@Test
	public void testAdd() throws Exception {
		String url = "http://localhost:8080/persons";
		
		Person person = new Person(1L, "Johnny");
		String personAsJson = mapper.writeValueAsString(person);
		
		this.mockMvc
				.perform(post(url).content(personAsJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
}
