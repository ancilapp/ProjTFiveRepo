package com.ProjTFive.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ProjTFive.base.Base;
import com.ProjTFive.utils.Utilities;

public class RegisterTest extends Base {

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = initialBrowserAndOpenUrl();
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyMandatoryFieldsMessages() {
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String FirstNameMsg = driver.findElement(By.xpath("//input[@name='firstname']//following-sibling::div")).getText();
		Assert.assertTrue(FirstNameMsg.contains("First Name must be between 1 and 32 characters!"));
		
		String LastNameMsg = driver.findElement(By.xpath("//input[@name='lastname']//following-sibling::div")).getText();
		Assert.assertTrue(LastNameMsg.contains("Last Name must be between 1 and 32 characters!"));
				
	}
	
	/*
	@DataProvider
	public Object[][] supplyTestData() {
		Object[][] data = {{"Dayone", "DayTwo"},{"DayThree","DayFour"}} ;
		return data;
	}
	*/
	
	@DataProvider
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Sheet1");
		return data;
	}
	
	@Test(dataProvider="supplyTestData")
	public void verifyPasswordMatchingMessage(String Passone, String Passtwo) {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ron");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Pascal");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Pascal@gmail.com");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Pascal");
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("1234567899");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Passone);
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(Passtwo);
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualMessage = driver.findElement(By.xpath("//input[@name='confirm']/following-sibling::div")).getText();
		
		//Assert.assertTrue(actualMessage.contains("Password confirmation does not match password!"));
		Assert.assertTrue(actualMessage.contains("WOW WOW WOW"));
	}
	
	@Test
	public void playWithExcel() {
		//TO DO :: get data from one particular cell
	}
}
