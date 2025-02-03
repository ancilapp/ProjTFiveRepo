package com.ProjTFive.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//Objects
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailAddressLogin;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordLogin;	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;	
	
	//Actions
	public void enterEmailAddress(String userid) {
		emailAddressLogin.sendKeys(userid);	}
	
	public void enterPassword(String pwd) {
		passwordLogin.sendKeys(pwd);	}

	public void clickLogin() {
		loginButton.click();	}
	
}
