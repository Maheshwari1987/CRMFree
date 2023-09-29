package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class LoginPageTest extends TestBase {

	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;

	// Constructor of LoginPAge
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		// create a object of MainPage class
		mainPage = new MainPage();
		loginPage = mainPage.loginClick();
	}

	@Test(priority = 1)
	public void loginToApp()
	{
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

	}

	@Test(priority = 2)
	public void verifyLoginTitlePage() {
		String loginTitle = loginPage.verifyTitleLogiPage();
		Assert.assertEquals(loginTitle, "Cogmento CRM", "Login Page Title Not Matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
