package samples.springboot;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Created by izeye on 15. 4. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class ApplicationTests {
	
	@Value("${local.server.port}")
	int port;

	RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		this.restTemplate = getRestTemplate();
	}
	
	@Test
	public void testSort() {
		String url = "http://localhost:{port}/api/customers?sort=firstName,desc";

		ResponseEntity<PagedResources<Customer>> responseEntity = this.restTemplate.exchange(
				url, HttpMethod.GET, null,
				new ParameterizedTypeReference<PagedResources<Customer>>() {},
				port);
		PagedResources<Customer> resources = responseEntity.getBody();
		List<Customer> customers = new ArrayList(resources.getContent());
		customers.forEach(System.out::println);
	}
	
	@Test
	public void testFindByLastNameNotLike() {
		String url = "http://localhost:{port}/api/customers/search/findByLastNameNotLike?lastName={lastName}";
		String lastName = "B%";
		
		ResponseEntity<PagedResources<Customer>> responseEntity = this.restTemplate.exchange(
				url, HttpMethod.GET, null,
				new ParameterizedTypeReference<PagedResources<Customer>>() {},
				port, lastName);
		PagedResources<Customer> resources = responseEntity.getBody();
		List<Customer> customers = new ArrayList(resources.getContent());
		customers.forEach(System.out::println);
		
		assertThat(customers.get(0), instanceOf(Customer.class));
		customers.forEach(customer -> assertThat(customer.getLastName(), not(startsWith("B"))));
	}

	private RestTemplate getRestTemplate() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new Jackson2HalModule());

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
		converter.setObjectMapper(mapper);
		return new RestTemplate(Arrays.asList(converter));
	}
	
}
