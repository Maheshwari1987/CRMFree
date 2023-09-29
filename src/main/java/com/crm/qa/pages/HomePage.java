package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// pageFactory
	
	@FindBy(xpath = "//span[text()='maheshwari m']")
	@CacheLookup
	WebElement loginUserDisplay;

	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contacts;

	@FindBy(xpath = "//span[text()='Companies']")
	WebElement companies;

	// initialize the page objects , so create a constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	// Create Methods/Functions
	public String verfiyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUser()
	{
		boolean loginUser = loginUserDisplay.isDisplayed();
		return loginUser;
	}
	public ContactPage clickonContacts() {
		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(contacts).perform();

		contacts.click();
		return new ContactPage();
	}
}
