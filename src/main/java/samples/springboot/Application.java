package samples.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by izeye on 15. 1. 31..
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

//	private final Yaml yaml = new Yaml(new Constructor(Person.class));
	private final Yaml yaml = new Yaml(
			new CustomClassLoaderConstructor(Person.class, Person.class.getClassLoader()));

	@Override
	public void run(String... args) throws Exception {
		File file = ResourceUtils.getFile("classpath:data/person.yml");
		Object object = yaml.load(new FileInputStream(file));
		System.out.println(Person.class.getClassLoader());
		System.out.println(object.getClass().getClassLoader());
		
		Person person = (Person) object;
		System.out.println(person);
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
