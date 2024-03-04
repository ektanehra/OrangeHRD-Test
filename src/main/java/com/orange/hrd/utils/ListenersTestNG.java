package com.orange.hrd.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTestNG implements ITestListener{
	Logger log = LogManager.getLogger();
 
	
	
	public void onTestStart(ITestResult result) {
		log.info("Test [{}] Starting", result.getTestName());
		
	}
	
	public void onTestFailure (ITestResult result) {
		log.info("Test [{}] Failed", result.getTestName());
	
	}
}
