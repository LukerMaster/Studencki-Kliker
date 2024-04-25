package ClickerGame;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Timer;

@Aspect
public class TimingAspect {

	@Pointcut(value="execution(* ClickerGame.Actions.*(..) )")
	public void myPointcut() {

	}

	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {

		long startTime = System.nanoTime();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object object = pjp.proceed();
		long endTime = System.nanoTime();
		long time = endTime - startTime;

		System.out.println(className + "." + methodName + " took " + time + "ms.");

		return object;
	}

}