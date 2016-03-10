package task;

import org.springframework.stereotype.Component;

@Component
public class BeanB {

	public void methodB1() {
		PrintUtils.printMessage("beanB.methodB1");
	}
	
	public void methodB() {
		PrintUtils.printMessage("beanB.methodB");
	}
}
