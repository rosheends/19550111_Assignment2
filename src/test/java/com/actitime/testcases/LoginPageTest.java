package com.actitime.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.base.TestBase;
import com.actitime.pages.HomePage;
import com.actitime.pages.LoginPage;
import com.actitime.util.TestUtil;

public class LoginPageTest extends TestBase{
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
	
	@DataProvider
	public Object[][] getactiTimeTestData() {
		Object[][] data=TestUtil.getTestData(sheetName);
		
		return data;		
	}
	
	@Test(priority = 1,dataProvider="getactiTimeTestData")
	public void LoginTest(String userName, String password) {
		homePage = loginPage.Login(userName, password);
	}
	
	
	@AfterMethod
	public void tearDown() {	
		driver.quit();
	}
}
