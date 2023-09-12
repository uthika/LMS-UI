package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class NavigationAttendance7Page {
    public static WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();

    public NavigationAttendance7Page() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text()='Attendance')]")
    WebElement btnAttendance;
    @FindBy(xpath = "//button[text()='student']")
    WebElement studentButton;
    @FindBy(xpath = "//button[text()='program']")
    WebElement programButton;
    @FindBy(xpath = "//button[text()='batch']")
    WebElement batchButton;
    @FindBy(xpath = "//button[text()='user']")
    WebElement userButton;
    @FindBy(xpath = "//button[text()='class']")
    WebElement classButton;
    @FindBy(xpath = "//button[text()='Assignment']")
    WebElement AssignmentButton;
    @FindBy(xpath = "//button[text()='login']")
    WebElement loginButton;

    public void assertPageTitle(String expectedtitle){
        String actualTitle = driver.getTitle();
        assertEquals(expectedtitle, actualTitle);
    }

    public void validateNavigaton(String option){
        switch (option){
            case "student": studentButton.click();
                assertPageTitle( "Student details page");
                break;

            case "program": programButton.click();
                assertPageTitle(  "program details page");
                break;

            case "batch": batchButton.click();
                assertPageTitle( "batch details page");
                break;

            case "user": userButton.click();
                assertPageTitle( "user details page");
                break;

            case "class": classButton.click();
                assertPageTitle( "class details page");
                break;

            case "Assignment": AssignmentButton.click();
                assertPageTitle( "Assignment details page");
                break;

            case "login": loginButton.click();
                assertPageTitle( "login details page");
                break;
        }

    }
}
