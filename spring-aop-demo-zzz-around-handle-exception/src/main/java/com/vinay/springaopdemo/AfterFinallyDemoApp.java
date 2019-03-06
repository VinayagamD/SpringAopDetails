package com.vinay.springaopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vinay.springaopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the bean from spring container
		AccountDAO accountDao = context.getBean("accountDAO",AccountDAO.class);
		
//		Call the method to find  the accounts
		List<Account> accounts =  null;			
		try {
			boolean tripWire = false;
			accounts =	accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("\n\n Main Program ... caught exception : " + e);
		}
		
//		display the accounts 
		System.out.println("\n\n Main Program : AfterThrowingDemoApp ");
		System.out.println("----------");
		
		System.out.println(accounts);
		
		System.out.println("\n");
 		
//		close the context
		context.close();
	}

}
