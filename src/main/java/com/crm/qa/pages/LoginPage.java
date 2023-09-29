package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository or page library
	//driver.FindElement(By.Xpath[//input(@name='xyz'])
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	
	
	//initialize the page objects , so create a constructor
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Create a methods
	public HomePage login(String emaill,String pwd)
	{
		email.sendKeys(emaill);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	public String verifyTitleLogiPage()
	{
		//String loginTitle = driver.getTitle();
		//return loginTitle;
		return driver.getTitle();
	}
	
}
