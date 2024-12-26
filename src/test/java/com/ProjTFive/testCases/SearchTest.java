package com.ProjTFive.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ProjTFive.base.Base;
import com.ProjTFive.pageObjects.HomePage;

public class SearchTest extends Base{

	public SearchTest() {
		super();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = initialBrowserAndOpenUrl();
		
		HomePage homepg = new HomePage(driver);
		homepg.clickMyAccount();
		homepg.clickLogin();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("validemail"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Selenium1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}

	@AfterMethod
	public void tearDown() {
	//	driver.quit();
	}
	
	@Test
	public void searchHonda() {
		HomePage homepg = new HomePage(driver);
		homepg.searchFor("Canon");
		homepg.clickSearch();
		
		String actualSearchResult = driver.findElement(By.xpath("//div[@id='content']//h4")).getText();
		String expectedSearchResult = "Canon EOS 5D";
		
		Assert.assertEquals(actualSearchResult, expectedSearchResult,"Search Failed");
		
	}
}
