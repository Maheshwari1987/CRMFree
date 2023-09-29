package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class HomePageTest extends TestBase{
	
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	
	public HomePageTest()
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
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String title = homePage.verfiyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM","Home page title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		boolean userName = homePage.verifyCorrectUser();
		Assert.assertTrue(userName);
	}
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		contactPage = homePage.clickonContacts();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
