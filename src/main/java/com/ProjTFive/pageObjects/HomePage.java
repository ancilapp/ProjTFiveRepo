package com.ProjTFive.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver,this);
	}
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement login;	
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBarTxt;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	//Actions
	public void clickMyAccount() {
		myAccountDropDown.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void searchFor(String searchItem) {
		searchBarTxt.sendKeys(searchItem);
	}
	
	public void clickSearch() {
		searchButton.click();
	}
}
