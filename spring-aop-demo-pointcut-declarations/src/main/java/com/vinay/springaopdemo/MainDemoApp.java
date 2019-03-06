package com.vinay.springaopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vinay.springaopdemo.dao.AccountDAO;
import com.vinay.springaopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the bean from spring container
		AccountDAO accountDao = context.getBean("accountDAO",AccountDAO.class);
		
//		get membership bean from spring bean container
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
//		call the business method
		accountDao.addAccount(new Account(),true);
		accountDao.doWork();
	
		
//		call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
/*//		do it again!
		System.out.println("\n let's call it again!\n");
		
//		call the business method again
		accountDao.addAccount();*/
		
//		close the context
		context.close();
	}

}
