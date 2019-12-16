package com.orange.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper {
	
	public static void captureScreenshot(WebDriver driver, String name)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/Orange_"+name+"_"+getStringData()+".png");
		try {
			FileHandler.copy(src,dest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ScreenShot:File not copied "+e.getMessage());
		}
		
		System.out.println("ScreenShot Captured");
	}
	
	public static String getStringData()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		
		Date date = new Date();
		return customformat.format(date);
	}

}
