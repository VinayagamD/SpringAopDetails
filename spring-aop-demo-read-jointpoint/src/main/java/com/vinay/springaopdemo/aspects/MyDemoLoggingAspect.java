package com.vinay.springaopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vinay.springaopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	
	
	@Before("com.vinay.springaopdemo.aspects.VinayAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n======>>> Execution @Before advice on method");
		
//		display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: "+methodSignature);
		
//		display method arguments
//		get args
		Object[] args = joinPoint.getArgs();
//		loop through the args
		for (Object arg : args) {
			System.out.println(arg);
			if(arg instanceof Account) {
//				downcast and print the Account specific stuff
				
				Account account = (Account) arg;
				System.out.println("Account Name : " +account.getName());
				System.out.println("Account Level : " +account.getLevel());
			}
				
		}
		
	}
	
	
	
	
	

}
