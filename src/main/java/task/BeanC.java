package task;

import org.springframework.stereotype.Component;

@Component
public class BeanC {

	public void methodC() {
		PrintUtils.printMessage("beanC.methodC");
	}
	
	public void methodC1() {
		PrintUtils.printMessage("beanC.methodC1");
	}
}
