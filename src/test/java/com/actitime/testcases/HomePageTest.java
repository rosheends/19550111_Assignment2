package com.actitime.testcases;

import com.actitime.base.TestBase;
import com.actitime.pages.HomePage;
import com.actitime.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.Login(properties.getProperty("username"), properties.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageTaskLinkTest() {
		homePage.clickOnTaskLink();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
