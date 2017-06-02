package demo.spring.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import demo.spring.aspect.app.domain.Foo;

@Aspect
@Component
public class AfterReturningExample {

	@AfterReturning(pointcut = "execution(* *(..))", returning = "retVal")
	public void doAccessCheck(Object retVal) {
		System.out.println(this.getClass().getSimpleName());
		System.err.println(retVal);
	}
	
	@AfterReturning(pointcut = "execution(* *(..))", returning = "retVal")
	public Object changeReturn(Object retVal) {
		System.out.println(this.getClass().getSimpleName());
		System.err.println(retVal);
		
		return new Foo("xx", 1);
	}

}
