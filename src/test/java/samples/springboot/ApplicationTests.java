package samples.springboot;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;

/**
 * Created by izeye on 15. 3. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {
	
	@Autowired
	JavaMailSender javaMailSender;

	@Test
	@Ignore
	public void testSend() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("izeye@naver.com");
		message.setSubject("Test");
		message.setText("This is a test.");
		javaMailSender.send(message);
	}

}
