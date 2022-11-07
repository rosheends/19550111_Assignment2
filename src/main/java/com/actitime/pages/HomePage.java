package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.base.TestBase;

public class HomePage extends TestBase{
	
	//WebDriver driver = new ChromeDriver();
	

	@FindBy(xpath = "//a[@class='content tasks']")
	WebElement taskLink;
	
	@FindBy(xpath = "//a[@class='content reports']")
	WebElement reportsLink;
	
	@FindBy(xpath = "//div[@id='logo_aT']")
	WebElement pageLogo;
	
	
	//initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public TasksPage clickOnTaskLink() {
		taskLink.click();
		return new TasksPage();
		
	}
	
	
    public ReportsPage clickOnReportsLink() {
		
         reportsLink.click();
         return new ReportsPage();
		
	}

}
