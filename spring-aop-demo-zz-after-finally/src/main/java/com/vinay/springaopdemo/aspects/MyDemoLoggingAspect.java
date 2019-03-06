package com.vinay.springaopdemo.aspects;

import java.util.List;
import java.util.function.Consumer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.vinay.springaopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
//		print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) on method: " +method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.vinay.springaopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
//		print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterException on method: " +method);
//		log the exception
		System.err.println("\n======>>> The exception is : " + exc);
		
	}

//	add a new advice for @AfterReturning on the find Accounts method
	@AfterReturning(
			pointcut="execution(* com.vinay.springaopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
//		print out the which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning onn method: " +method);
		
//		print out the result of the method call
		
		System.out.println("\n===========>>> Result is: " + result);
		
//		let's post-process the data ... let's modify it :-
		
//		convert the  account names to upper case
		
		Consumer<Account> consumer = (account) -> account.setName(account.getName().toUpperCase()); 
		result.forEach(consumer);
		System.out.println("\n===========>>> Result is: " + result);

	}
	
	
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
