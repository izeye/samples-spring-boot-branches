package samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.ProxyAsyncConfiguration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * Created by izeye on 15. 3. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ProxyAsyncConfiguration proxyAsyncConfiguration;

	@Autowired
	AsyncAnnotationBeanPostProcessor asyncAnnotationBeanPostProcessor;

	@Test
	public void test() {
		for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
			Object bean = applicationContext.getBean(beanDefinitionName);
			System.out.println(bean.getClass());
		}
	}

	@Test
	public void testAsync() {
		Object executor = ReflectionTestUtils.getField(proxyAsyncConfiguration, "executor");
		assertThat(executor, is(instanceOf(ThreadPoolTaskExecutor.class)));

		Object advisor = ReflectionTestUtils.getField(asyncAnnotationBeanPostProcessor, "advisor");
		Object advice = ReflectionTestUtils.getField(advisor, "advice");
		Object defaultExecutor = ReflectionTestUtils.getField(advice, "defaultExecutor");
		assertThat(defaultExecutor, is(instanceOf(ThreadPoolTaskExecutor.class)));
	}

}
