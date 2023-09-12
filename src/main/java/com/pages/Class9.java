package com.pages;

import com.qa.factory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Class9 {
	
	WebDriver driver;
	
	public Class9()
	{
		 this.driver = DriverFactory.getDriver();
	     PageFactory.initElements(driver, this);	
	}
    
    @FindBy(xpath = "//button[text()='student']") WebElement studentButtn;
    @FindBy(xpath = "//button[text()='program']") WebElement programButtn;
    @FindBy(xpath = "//button[text()='batch']") WebElement batchButtn;
    @FindBy(xpath = "//button[text()='user']") WebElement userButtn;
    @FindBy(xpath = "//button[text()='class']") WebElement assgnmntButtn;
    @FindBy(xpath = "//button[text()='Attendance']") WebElement attnButtn;

    public void assertPageTitle(String expectedtitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedtitle, actualTitle);
    }
	
public void validateNavig(String pages) {
		
		switch(pages) {
		case "Student": studentButtn.click();
		assertPageTitle("Students details page");
		break;
		
		case "Program": programButtn.click();
		assertPageTitle("Program details page");
		break;
		
		case "Batch": batchButtn.click();
		assertPageTitle("Batch details page");
		break;
		
		case "User": userButtn.click();
		assertPageTitle("User details page");
		break;
		
		case "Assignment": assgnmntButtn.click();
		assertPageTitle("Assignment details page");
		break;
		
		case "Attendance": attnButtn.click();
		assertPageTitle("Attendance details page");
		break;
		}
}
}