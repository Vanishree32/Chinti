package com.pmt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement emailField;
	
	@FindBy(id="password")
	private WebElement password;
	
	public LoginPage(WebDriver driver)
	{
     PageFactory.initElements(driver,this);
	}
	
	
}
