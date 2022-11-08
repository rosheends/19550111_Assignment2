package com.assignment2.testcases;

import com.assignment2.base.TestBase;
import com.assignment2.pages.HomePage;
import com.assignment2.pages.LoginPage;

import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	@Test(priority = 2)
	public void homePageUsersLinkTest() {
		homePage.clickOnUsersLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
