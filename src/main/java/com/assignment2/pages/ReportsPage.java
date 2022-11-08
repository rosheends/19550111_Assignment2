package com.assignment2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment2.base.TestBase;

public class ReportsPage extends TestBase{
	@FindBy(xpath = "//table[@id='reportConfig_88']")
	WebElement reportLink;

	// initialization
	public ReportsPage() {
		PageFactory.initElements(driver, this);
	}

	public AttendanceReportPage clickOnAttendanceReportLink() {
		reportLink.click();
		return new AttendanceReportPage();

	}
}
