package task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//		TaskExecutorExample task = (TaskExecutorExample) context.getBean("taskExecutorExample");
//		task.printMessages();
	}
}
