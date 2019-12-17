package com.oranges.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orange.utility.BrowserFactory;
import com.orange.utility.ConfigDataProvider;
import com.orange.utility.ExcelDataProvider;
import com.orange.utility.Helper;

public class BaseClass {

	WebDriver driver;
	ExcelDataProvider excel;
	ConfigDataProvider config;
	ExtentReports report;
	ExtentTest logger; 

	@BeforeSuite
	public void createObject() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/Orange_"+Helper.getCurrentDate()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
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
		String temp=null;
		if (ITestResult.FAILURE == result.getStatus()) {
			temp=Helper.captureScreenshot(driver, result.getName());
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("."+temp).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("ScreenShot:MediaEntityBuilder not uploadin-->"+e.getMessage());
			}
		}
			else if(ITestResult.SUCCESS == result.getStatus())
			{
				try {
					logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath("."+temp).build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("ScreenShot:MediaEntityBuilder not uploadin-->"+e.getMessage());
				}
			}
            driver.quit();
		
		report.flush();
	}

}
