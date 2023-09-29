package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class MainPageTest extends TestBase {
	MainPage mainPage;
	LoginPage loginPage;

	public MainPageTest() {
		// when super class constructor i.e TestBase constructor is called . Before
		// init() method in below method
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		// create a object of MainPage class
		mainPage = new MainPage();
	}

	@Test(priority=1)
	public void homePageTitleTest() {
		String title = mainPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM Power Up your Entire Business Free Forever");
	}

	@Test(priority=2)
	public void clickonLogin() {
		loginPage = mainPage.loginClick();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
