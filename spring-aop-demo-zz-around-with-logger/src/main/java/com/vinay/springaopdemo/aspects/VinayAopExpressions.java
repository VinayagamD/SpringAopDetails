package com.vinay.springaopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class VinayAopExpressions {
	@Pointcut("execution(* com.vinay.springaopdemo.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
//	create pointcut for getter methods
	@Pointcut("execution(* com.vinay.springaopdemo.dao.*.get*(..))")
	public void getter() {
		
	}
//	create pointcut for setter metthods
	@Pointcut("execution(* com.vinay.springaopdemo.dao.*.set*(..))")
	public void setter() {
		
	}
//	create pointcut: include packages ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
		
	}
}
