package demo.spring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterFinallyExample {

    @After("execution(* *(..))")
    public void doReleaseLock() {
        System.out.println(this.getClass().getSimpleName());
    }

}