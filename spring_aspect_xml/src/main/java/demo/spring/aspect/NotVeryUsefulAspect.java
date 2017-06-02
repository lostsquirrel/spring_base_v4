package demo.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NotVeryUsefulAspect {

	@Pointcut("execution(* transfer(..))")// the pointcut expression
	private void anyOldTransfer() {}// the pointcut signature
	
	@Pointcut("execution(public * *(..))")
	private void anyPublicOperation() {}

	@Pointcut("within(com.xyz.someapp.trading..*)")
	private void inTrading() {}

	@Pointcut("anyPublicOperation() && inTrading()")
	private void tradingOperation() {}
}
