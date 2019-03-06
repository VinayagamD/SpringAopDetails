package com.vinay.springaopdemo.aspects;

import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	private Logger logger = Logger.getLogger(getClass().getName()); 
	
	@Around("execution(* com.vinay.springaopdemo.service.*.getFortune(..)))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws Throwable {
		
//		printing out the method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @Around on method: " +method);
		
//		get begin timestamp
		long begin = System.currentTimeMillis();
		
//		now, let's execute method
		Object result = proceedingJoinPoint.proceed();
		
		
//		get end timestamp
		long end = System.currentTimeMillis();
		
//		compute the duration and display it
		long duration = end - begin;
		logger.info("\n======> Duration : "+duration/1000.0+ " seconds");
		
		return result;
		
	}
	
	@After("execution(* com.vinay.springaopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
//		print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @After (finally) on method: " +method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.vinay.springaopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
//		print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @AfterException on method: " +method);
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
		logger.info("\n=====>>> Executing @AfterReturning onn method: " +method);
		
//		print out the result of the method call
		
		logger.info("\n===========>>> Result is: " + result);
		
//		let's post-process the data ... let's modify it :-
		
//		convert the  account names to upper case
		
		Consumer<Account> consumer = (account) -> account.setName(account.getName().toUpperCase()); 
		result.forEach(consumer);
		logger.info("\n===========>>> Result is: " + result);

	}
	
	
	@Before("com.vinay.springaopdemo.aspects.VinayAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("\n======>>> Execution @Before advice on method");
		
//		display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("Method: "+methodSignature);
		
//		display method arguments
//		get args
		Object[] args = joinPoint.getArgs();
//		loop through the args
		for (Object arg : args) {
			logger.info(arg.toString());
			if(arg instanceof Account) {
//				downcast and print the Account specific stuff
				
				Account account = (Account) arg;
				logger.info("Account Name : " +account.getName());
				logger.info("Account Level : " +account.getLevel());
			}
				
		}
		
	}
	
	
	
	
	

}
