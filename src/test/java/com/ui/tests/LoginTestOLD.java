package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utils.BrowserUtility;

public class LoginTestOLD {

	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();

		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");
		browserUtility.maximize();

		By signInLocator = By.xpath("//a[contains(text(),\"Sign\")]");
		browserUtility.clickOn(signInLocator);

		By emailIdTextBoxLocator = By.id("email");
		browserUtility.enterText(emailIdTextBoxLocator, "nixeha9252@bullbaby.com");

		By passwordTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "password");

		By signInButtonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(signInButtonLocator);

		/*
		 * WebElement signIn = wd.findElement(By.id("SubmitLogin"));
		 * 
		 * WebElement ps = wd.findElement(By.id("passwd"));
		 * 
		 * we can do this in one line
		 * 
		 * setup(selenium code) can be done in different class and any test that needs
		 * to open the chrome can use that class
		 * 
		 * locator elements can be kept private so than any other class cant modify it
		 * 
		 * 
		 */

	}

}
