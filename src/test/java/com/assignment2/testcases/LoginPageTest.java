package com.assignment2.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.assignment2.base.TestBase;
import com.assignment2.pages.HomePage;
import com.assignment2.pages.LoginPage;
import com.assignment2.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	String sheetName = "sheet1";
	TestUtil testUtil;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@DataProvider (name = "getactiTimeTestData")
	public Object[][] getactiTimeTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}

	@Test(priority = 1, alwaysRun = true, dataProvider = "getactiTimeTestData")
	public void LoginTest(String userName, String password) {
		homePage = loginPage.Login(userName, password);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
