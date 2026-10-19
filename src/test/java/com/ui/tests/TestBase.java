package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utils.BrowserUtility;
import com.utils.LoggerUtility;
import com.utils.lambdaTestUtility;

public class TestBase {
	
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest = true;
	
	
	@Parameters({"browser","isLambdaTest","isHeadLess"})
	@BeforeMethod(description = "launching the Homepage of the website")
	public void setUp(
			@Optional ("chrome") String browser, 
			@Optional ("false") boolean isLambdaTest, 
			@Optional ("true") boolean isHeadless, ITestResult result) {
		WebDriver lambdaDriver;
		this.isLambdaTest = isLambdaTest;
		if(isLambdaTest) {
			
			lambdaDriver = lambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
			
		}else { // will run the test in local machine
			logger.info("launching the Homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description = "Tear down the browser")
	public void TearDown() {
		if(isLambdaTest) {
			lambdaTestUtility.quitSession();
		}else {
			homePage.quit();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
