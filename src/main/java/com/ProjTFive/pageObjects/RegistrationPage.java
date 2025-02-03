package com.ProjTFive.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver,this);
	}
	
	//Objects
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement confirmPassword;
	
	
	//Actions
	public void clickContinue() {
		continueButton.click();
	}
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		emailAddress.sendKeys(email);
	}
	
	public void enterPhoneNumber(String pnumber) {
		phoneNumber.sendKeys(pnumber);
	}
	
	public void enterPassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void enterPasswordConfirmation(String cpword) {
		confirmPassword.sendKeys(cpword);
	}
}
