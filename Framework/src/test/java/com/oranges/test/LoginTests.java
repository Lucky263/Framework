package com.oranges.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.orange.pages.LoginPage;

public class LoginTests extends BaseClass {

	@Test
	public void validLogin() throws InterruptedException {
		logger=report.createTest("Valid login to Orange");
        logger.info("URL Itializing");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		String usrName = excel.getStringData("Login", 1, 0);
		String password = excel.getStringData("Login", 1, 1);
		loginPage.login(usrName, password);
		logger.pass("Login successfully");
		Thread.sleep(3000);
	}

}
