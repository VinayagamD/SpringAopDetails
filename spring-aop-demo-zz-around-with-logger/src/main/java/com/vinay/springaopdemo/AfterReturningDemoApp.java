package com.vinay.springaopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vinay.springaopdemo.dao.AccountDAO;
import com.vinay.springaopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the bean from spring container
		AccountDAO accountDao = context.getBean("accountDAO",AccountDAO.class);
		
//		Call the method to find  the accounts
		List<Account> accounts = accountDao.findAccounts(false);
		
//		display the accounts 
		System.out.println("\n\n Main Program : AfterReturningDemoApp ");
		System.out.println("----------");
		
		System.out.println(accounts);
		
		System.out.println("\n");
 		
//		close the context
		context.close();
	}

}
