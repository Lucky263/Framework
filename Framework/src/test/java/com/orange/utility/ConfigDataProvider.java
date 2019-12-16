package com.orange.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {
		File src = new File("./Configurations/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Properties file not able load " + e.getMessage());

		}
	}

	public String getValueOfKey(String key) {
		return pro.getProperty(key);
	}

	public String getBrowser() {
		return pro.getProperty("Browser");
	}

	public String getQAUrl() {
		return pro.getProperty("qaURL");
	}
}
