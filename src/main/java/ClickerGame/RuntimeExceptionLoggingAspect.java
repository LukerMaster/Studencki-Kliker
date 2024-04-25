package ClickerGame;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RuntimeExceptionLoggingAspect {

    @Pointcut("within(ClickerGame.*)")
    public void allMethodsPointcut() {

    }

    @AfterThrowing(pointcut = "allMethodsPointcut()", throwing = "ex")
    public void logRuntimeException(JoinPoint joinPoint, RuntimeException ex) {
        System.err.println("A RuntimeException was thrown in: " + joinPoint.getSignature());
        System.err.println("Error message: " + ex.getMessage());
    }
}