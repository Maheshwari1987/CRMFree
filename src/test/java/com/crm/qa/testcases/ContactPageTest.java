package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactAddPage;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class ContactPageTest extends TestBase{
	
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	ContactAddPage contactAddPage;

	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		init();
		// create a object of MainPage class
		mainPage = new MainPage();
		loginPage = new LoginPage();
		mainPage.loginClick();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
		contactPage = homePage.clickonContacts();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest()
	{
		Assert.assertTrue(contactPage.verifyContactsLabel(),"contact label is missing");
	}
	
	@Test(priority=2)
	public void verifyMouseOver()
	{
		contactAddPage = contactPage.mouseover();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
