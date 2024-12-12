package com.ProjTFive.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ProjTFive.utils.Utilities;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public Base() {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ProjTFive\\config\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initialBrowserAndOpenUrl() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		//driver.get("http://www.yahoo.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.PURPOSE_WAIT_TIME_MED));
		
		return driver;

	}
}
