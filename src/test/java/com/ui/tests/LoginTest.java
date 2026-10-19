package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.user;
import com.utils.LoggerUtility;



@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase{
	
	@Test(description = "verifies whether a valid user is logging into application", groups = { "e2e", "sanity" }
	, dataProviderClass = com.ui.dataProviders.loginDataProviders.class, dataProvider = "LoginTestDataProvider")
	public void LoginTest(user user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Prarthana Raman");
	}
	
	/*
	//csv
	@Test(description = "verifies whether a valid user is logging into application", groups = { "e2e", "sanity" }
	, dataProviderClass = com.ui.dataProviders.loginDataProviders.class, dataProvider = "LoginTestCSVDataProvider")
	public void LoginCSVTest(user user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Prarthana Raman");
	} 
	//excel
	@Test(description = "verifies whether a valid user is logging into application", groups = { "e2e", "sanity" }
	, dataProviderClass = com.ui.dataProviders.loginDataProviders.class, dataProvider = "LoginTestExcelDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void LoginExcelTest(user user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Prarthana Raman1");

	}
	*/

}
