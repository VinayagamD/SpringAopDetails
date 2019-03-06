package com.vinay.springaopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.vinay.springaopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
//	create pointcut for getter methods
	@Pointcut("execution(* com.vinay.springaopdemo.dao.*.get*(..))")
	private void getter() {
		
	}
//	create pointcut for setter metthods
	@Pointcut("execution(* com.vinay.springaopdemo.dao.*.set*(..))")
	private void setter() {
		
	}
//	create pointcut: include packages ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
		
	}
	
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Execution @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n========>>> Performing API Analytics ");
	}

}
