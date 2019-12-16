package com.oranges.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.orange.pages.LoginPage;

public class LoginTests extends BaseClass {

	@Test
	public void validLogin() throws InterruptedException {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		String usrName = excel.getStringData("Login", 1, 0);
		String password = excel.getStringData("Login", 1, 1);
		loginPage.login(usrName, password);
		Thread.sleep(3000);
	}

}
