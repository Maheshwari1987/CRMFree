package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactAddPage  extends TestBase{
	
	@FindBy(xpath="//span[text()='Create New Contact']")
	WebElement createNewAccountLabel;

	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	//driver.findElement(By.name("title"));
	/*
	 * @FindBy(name="source") WebElement src;
	 */
	
	@FindBy(name="source")
	WebElement src;

	@FindBy(xpath="//button[text()='Save']" )
	WebElement savebtn;
	
	public ContactAddPage()
	{
		PageFactory.initElements(driver,this );
	}
	
	//Method
	public boolean verifyContactAddLabel()
	{
		return createNewAccountLabel.isDisplayed();
	}
	
	
	public void createNewContact(String fName, String lName, String source) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		src.click();
		 
		/*
		 * Select select = new Select(src); 
		 * select.selectByVisibleText(source);
		 */
		WebElement dropdown = driver.findElement(By.xpath("//div/span[contains(text(), '" + source + "')]"));

		dropdown.click();
		
		savebtn.click();
		//System.out.println("saved");
		
	}
	
}
