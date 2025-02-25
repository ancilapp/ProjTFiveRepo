package com.ProjTFive.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ProjTFive.base.Base;
import com.ProjTFive.pageObjects.HomePage;

public class ShowAllTest extends Base {

	public ShowAllTest() {
		super();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = initialBrowserAndOpenUrl();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void searchshowAllDesktops() {
		HomePage homepg = new HomePage(driver);

		var desktopEle = driver.findElement(By.linkText("Desktops"));
		
		Actions action  = new Actions(driver);
		action.moveToElement(desktopEle).perform();
		
		driver.findElement(By.linkText("Show AllDesktops")).click();
		
		//String actualSearchResult = driver.findElement(By.xpath("//div[@id='content']//h4")).getText();
		//String expectedSearchResult = "Canon EOS 5D";
		
		//Assert.assertEquals(actualSearchResult, expectedSearchResult,"Search Failed");
		
	}
	
}
