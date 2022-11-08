package com.assignment2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment2.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@type='password'and @name='pwd']")
	WebElement passWord;

	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;

	@FindBy(xpath = "//input[@name='remember']")
	WebElement keepmeLoggedinCheckBox;

	@FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
	WebElement forgotYourPasswordLink;

	// initialization

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage Login(String uName, String pwd) {
		userName.sendKeys(uName);
		passWord.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}

}
