package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Environment;
import com.utils.JSONUtil;
import com.utils.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	// from config.properties
	//private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Environment.DEV, "MAX_NUMBER_OF_ATTEMPTS"));
	
	// from json utility
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtil.readJSON(Environment.DEV).getMAX_NUMBER_OF_ATTEMPTS();

	
	
	private static int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}
