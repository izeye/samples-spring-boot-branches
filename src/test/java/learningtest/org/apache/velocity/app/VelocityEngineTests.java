package learningtest.org.apache.velocity.app;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;

import java.io.StringWriter;

/**
 * Created by izeye on 15. 7. 17..
 */
public class VelocityEngineTests {
	
	@Test
	public void test() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		
		Template template = velocityEngine.getTemplate("templates/index.vm", "UTF-8");

		StringWriter sw = new StringWriter();
		template.merge(new VelocityContext(), sw);
		System.out.println(sw);
	}
	
}
