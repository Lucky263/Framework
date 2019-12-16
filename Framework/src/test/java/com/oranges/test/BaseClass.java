package com.oranges.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.orange.utility.BrowserFactory;
import com.orange.utility.ConfigDataProvider;
import com.orange.utility.ExcelDataProvider;
import com.orange.utility.Helper;

public class BaseClass {

	WebDriver driver;
	ExcelDataProvider excel;
	ConfigDataProvider config;

	@BeforeSuite
	public void createObject() {
		excel = new ExcelDataProvider();

		config = new ConfigDataProvider();
	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.intiateUrl(config.getBrowser(), config.getQAUrl());
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			Helper.captureScreenshot(driver, result.getName());
            driver.quit();
		}
	}

}
