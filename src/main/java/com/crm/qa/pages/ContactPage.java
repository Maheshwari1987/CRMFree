package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[text()='Create']")
	WebElement createContactBtn;
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public ContactAddPage mouseover()
	{
		 //Instantiate Action Class        
        Actions actions = new Actions(driver);
        //Retrieve WebElemnt 'slider' to perform mouse hover 
    	//Move mouse to x offset 50 i.e. in horizontal direction
    	actions.moveToElement(createContactBtn,50,0).perform();
    	createContactBtn.click();
    	return new ContactAddPage();
	}
	

}
