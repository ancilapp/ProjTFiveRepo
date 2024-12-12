package com.ProjTFive.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ProjTFive.base.Base;
import com.ProjTFive.pageObjects.HomePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends Base{
	

	public LoginTest() {
		super();
	}
	
	public WebDriver driver;

	
	
	@BeforeMethod
	public void setUp() {
		
		driver = initialBrowserAndOpenUrl();
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.xpath("//a[text()='Login']")).click();
		HomePage homepg = new HomePage(driver);
		homepg.clickMyAccount();
		homepg.clickLogin();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void validateValidLogin() {	
		

		//###############FOR FIRST BRACH PUSH######
		
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pascalron54@gmail.com");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("validemail"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Selenium1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Step Failed");
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Step Failed");
		
	}
	
	@Test
	public void validateInvalidCreds() {
		
		//driver.findElement(By.id("input-email")).sendKeys("pascalron54@gmail.com");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pasdajhk@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Selenium1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText(); 
		String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
		//String expectedMessage = "WOW WOW WOW";
		
		Assert.assertTrue(actualMessage.contains(expectedMessage),"step failed");
		
	}
}
