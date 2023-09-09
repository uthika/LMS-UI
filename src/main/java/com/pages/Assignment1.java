package com.pages;
import com.qa.factory.DriverFactory;
import com.qa.util.LoggerLoad;
import com.qa.util.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.apache.lucene.search.*;

import java.util.Properties;
public class Assignment1 {

    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    long endtime, starttime;
    public Assignment1(){
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Assignment']") WebElement newAssignmentButton;
    @FindBy(xpath = "//header[@id='header-id']") WebElement Header;
    @FindBy(xpath = "//html/body") WebElement body;
    @FindBy (xpath ="//button[text()='Delete']") WebElement DeleteIcon;
    @FindBy (xpath ="//button[text()='Search']") WebElement SearchBox;
    public void dashboard(){
        String dashboardURL = prop.getProperty("DashBoardURl");

        driver.get("DashBoardURl");
        long starttime = System.currentTimeMillis();
        String mytitle = driver.getTitle();
        String title = "DashboardPage";
        Assert.assertEquals(title, mytitle);

    }

    public void clickAssignmentButton(){
        newAssignmentButton.click();
        long endtime = System.currentTimeMillis();
        String Assignmentpage = driver.getTitle();
        String Title = "Manage Assignment Page";
        Assert.assertEquals(Title,Assignmentpage );

    }

    public void ManageURL(){

        String AssignmentURL = driver.getCurrentUrl();
        Assert.assertTrue("URL should contain Manage ", AssignmentURL.contains("Manage assignment"));
    }

    public void validateResponseTime(){
        long responsetime = endtime - starttime;
        System.out.println("Response time: "+responsetime + "milliseconds");
        LoggerLoad.info("The response time is " +responsetime );

    }

    public void verifyHeader(){
        String headerText = Header.getText();
        Assert.assertTrue("Header should contain Manage Assignment", headerText.contains("Manage Assignment"));

    }

    public void Spellcheck(){
        String portalpage = body.getText();
//        SpellChecker
    }

    public void verifyDeleteicon() {
        boolean iconisdisabled = !DeleteIcon.isEnabled();
        Assert.assertTrue("Delete icon is disabled",iconisdisabled );
        Assert.assertTrue("Disabled Delete icon is displayed ", DeleteIcon.isDisplayed());
    }

    public void verifySearchBar(){

        Assert.assertTrue("Search box is displayed", SearchBox.isDisplayed());
    }
}


