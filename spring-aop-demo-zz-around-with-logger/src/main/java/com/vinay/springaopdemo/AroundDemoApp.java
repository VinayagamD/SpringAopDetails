package com.vinay.springaopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vinay.springaopdemo.dao.AccountDAO;
import com.vinay.springaopdemo.dao.MembershipDAO;
import com.vinay.springaopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling get Fortune");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("\n My Fortune is : " + data);
		
		System.out.println("Finished");
		
//		close the context
		context.close();
	}

}
