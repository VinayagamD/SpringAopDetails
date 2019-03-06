package com.vinay.springaopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vinay.springaopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling get Fortune");
		
		String data = trafficFortuneService.getFortune();
		
		myLogger.info("\n My Fortune is : " + data);
		
		myLogger.info("Finished");
		
//		close the context
		context.close();
	}

}
