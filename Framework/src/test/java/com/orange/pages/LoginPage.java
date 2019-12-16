package com.orange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//input[@id='txtUsername']") WebElement txtFieldUname;
	@FindBy(xpath="//input[@id='txtPassword']") WebElement txtFieldPass;
	@FindBy(xpath="//input[@id='btnLogin']") WebElement btnLogin;
	
	
	public void login(String uname, String pass)
	{
		txtFieldUname.sendKeys(uname);
		txtFieldPass.sendKeys(pass);
		btnLogin.click();
	}

}
