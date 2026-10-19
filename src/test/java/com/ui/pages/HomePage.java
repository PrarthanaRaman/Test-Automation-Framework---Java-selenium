package com.ui.pages;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Environment.*;
import com.utils.BrowserUtility;
import com.utils.JSONUtil;
import com.utils.LoggerUtility;

import static com.utils.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browser, boolean isHeadless) {
		super(browser,isHeadless);
		goToWebsite(JSONUtil.readJSON(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtil.readJSON(QA).getUrl());
		
	}

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

	public LoginPage goToLoginPage() {
		logger.info("Logging in on the website!!!!!");
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
