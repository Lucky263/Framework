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
	
	public static String captureScreenshot(WebDriver driver, String name)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destPath ="./Screenshots/Orange_"+name+"_"+getCurrentDate()+".png";
		File dest = new File(destPath);
		try {
			FileHandler.copy(src,dest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ScreenShot:File not copied "+e.getMessage());
		}
		
		System.out.println("ScreenShot Captured");
		return destPath;
	}
	
	public static String getCurrentDate()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		
		Date date = new Date();
		return customformat.format(date);
	}

}
