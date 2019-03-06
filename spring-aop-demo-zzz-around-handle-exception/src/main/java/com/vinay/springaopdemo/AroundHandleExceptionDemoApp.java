package com.vinay.springaopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vinay.springaopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling get Fortune");
		
		String data;
		try {
			boolean tripWire = true;
			
			data = trafficFortuneService.getFortune(tripWire);
			myLogger.info("\n My Fortune is : " + data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		myLogger.info("Finished");
		
//		close the context
		context.close();
	}

}
