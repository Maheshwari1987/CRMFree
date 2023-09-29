package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactAddPage;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import com.crm.qa.util.TestUtil;

public class ContactsAddPageTest extends TestBase{
	

	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	ContactAddPage contactAddPage;
	
	String sheetName = "contacts";

	public ContactsAddPageTest()
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
		contactAddPage = contactPage.mouseover();
	}
	
	@Test
	public void validateAddNewContactLabelTest()
	{
		Assert.assertTrue(contactAddPage.verifyContactAddLabel(), "IS visible");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		 Object data[][] = TestUtil.getTestData(sheetName);
		 return data;
	}
	
	@Test(priority=2,dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String firstName,String lastName,String source)
	{
		contactAddPage.createNewContact(firstName,lastName,source);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
