package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MainPage extends TestBase{
	
	//Page Factory or Object Repository
	   //driver.findElement(By.xpath[//span[text()='Log In']])
		@FindBy(xpath = "//span[text()='Log In']")
		WebElement loginbtn;
		
		@FindBy(xpath="//span[text()=' sign up']")
		WebElement signUpbtn;
		
		//initialize the page objects , so create a constructor
		//this -- poinintng to current class object , All the webelements will be initialize
		public MainPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Create a actions/fuctionallity to validate login page
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public LoginPage loginClick()
		{
			loginbtn.click();
			//Once click on Login page its move to Login page (chain paging), so the return type login page
			return 	new LoginPage();
		}

}
