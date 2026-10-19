package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	private static ExtentReports extentReports; // one single report for 1 run so creating a static variable / class variable
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static void setUpSparkReporter(String ReportName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//"+ReportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		
	}
	public static void createExtentTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}
	public static ExtentTest getTest() {
			return extentTest.get();
	}
	public static void flushReport() {
		extentReports.flush();

	}

}
