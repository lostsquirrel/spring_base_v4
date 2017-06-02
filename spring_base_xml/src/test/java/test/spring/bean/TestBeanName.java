package test.spring.bean;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanName {

	private final Logger log = LoggerFactory.getLogger(TestBeanName.class);
	
	ApplicationContext context;
	
	@Before
	public void initTest() {
		context = new ClassPathXmlApplicationContext(new String[] {"bean/test-bean-name.xml"});
	}
	
	@Test
	public void testGetBeanById() {
		Foo foo = context.getBean("foo", Foo.class);
		log.info(foo.toString());
	}
	
	@Test
	public void testGetBeanByName() {
		for(int i = 1; i < 4; i++) {
			Foo foox = context.getBean("foo" + i, Foo.class);
			foox.setFooMessage("This is Foo Message with name: foo" + i);
			log.info(foox.toString());
		}
	}
	
	@Test
	public void testGetBeanByAlias() {
		String[] alias = {"fooA1", "fooA2", "fooB1", "fooB2"};
		for(String a : alias) {
			Foo foox = context.getBean(a, Foo.class);
			foox.setFooMessage("This is Foo Message with alias: " + a);
			log.info(foox.toString());
		}
	}
}
