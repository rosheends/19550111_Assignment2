package com.assignment2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment2.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@class='content tasks']")
	WebElement taskLink;
	
	@FindBy(xpath = "//a[@class='content users']")
	WebElement usersLink;

	// initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public TasksPage clickOnTaskLink() {
		taskLink.click();
		return new TasksPage();

	}
	
	public UsersPage clickOnUsersLink() {
		usersLink.click();
		return new UsersPage();

	}
}
