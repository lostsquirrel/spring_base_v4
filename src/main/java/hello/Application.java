package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {"application-context.xml"});
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}
