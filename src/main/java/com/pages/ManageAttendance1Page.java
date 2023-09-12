package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.LoggerLoad;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Properties;
import static org.junit.Assert.*;

public class ManageAttendance1Page {
    public static WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    long endtime, starttime;

    public ManageAttendance1Page() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text()='Attendance')]")
    WebElement btnAttendance;
    WebElement deleteIcon = driver.findElement(By.cssSelector(".delete-icon"));
   @FindBy(id="search-bar-id") WebElement searchBar;
   @FindBy(xpath="//button[contains(text()='+A New Attendance')]") WebElement addNewAttendanceBtn;
    @FindBy(xpath = "//button[@id='checkbox']")
    WebElement checkbox;
    @FindBy(xpath = "//header[text()='classID']")
    WebElement classID;
    @FindBy(xpath = "//header[text()='studentID']")
    WebElement studentID;
    @FindBy(xpath = "//header[text()='present']]")
    WebElement present;
    @FindBy(xpath = "//button[text()='edit/delete']")
    WebElement editORdelete;
    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr"));
    List<WebElement> columnheaders = driver.findElements(By.xpath("//table[@id='data-table']/tbody/tr/th"));
    @FindBy(xpath = "//button[@id='Pagination']") WebElement pagination;
    @FindBy(xpath ="//*[@id ='total assignment']" )WebElement footerMesg;
    public void dashboard() {
        String dashboardURL = prop.getProperty("DashBoardURl");
        driver.get("DashBoardURl");
        LoggerLoad.info("********Opening LMS Portal********");
        System.out.println("Validating Manage Attendance Page");
        long starttime = System.currentTimeMillis();
        String mytitle = driver.getTitle();
        String title = "DashBoard Page";
        Assert.assertEquals(title, mytitle);
    }
    public void clickAttendanceButton() {
        btnAttendance.click();
        long endtime = System.currentTimeMillis();
    }
    public void verifyLinkBroken() {

        String linkUrl = btnAttendance.getAttribute("href");
        int responseCode = 0;
        if (responseCode >= 400) {
            System.out.println("The link is broken (HTTP 400 Bad Request)");
        } else {
            System.out.println("The link is working (HTTP " + responseCode + ")");
        }

    }
    public void getTextPortalPage() {

        List<WebElement> allTextElements = driver.findElements(By.xpath("//*[not(self::script)]/text()"));

        for (WebElement element : allTextElements) {
            System.out.println(element.getText());
        }
    }
    public void checkSpelling(){
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));

        for (WebElement inputField : inputFields) {
            String fieldValue = inputField.getAttribute("value");
            System.out.println("Checking spelling for field: " + fieldValue);
        }
    }
    public void verifyDisabledDeleteIcon() {
                            assert deleteIcon.isEnabled() == false;
    }
    public void verifySearchBarPresence() {
        Assert.assertTrue("Search bar is displayed.", searchBar.isDisplayed());
    }
    public void verifyNewAttendanceBtn(){
        assertNotNull("Button found", addNewAttendanceBtn);
    }
    public void verifyTableColumnHeaders() {
        Assert.assertTrue("check box is displayed", checkbox.isDisplayed());
        Assert.assertTrue("header classID is displayed", classID.isDisplayed());
        Assert.assertTrue("header studentID is displayed", studentID.isDisplayed());
        Assert.assertTrue("header present is displayed", present.isDisplayed());
        Assert.assertTrue("header Edit/delete is displayed", editORdelete.isDisplayed());
    }
    public void verifyEditIcon() {

                for (WebElement row : rows) {
            WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
            String celltext = cellEntry.getText();
            if (!celltext.isEmpty()) {
                WebElement editIcon = row.findElement(By.xpath("//td[@class='edit-icon']"));
                Assert.assertTrue("Edit icon is displayed ",editIcon.isDisplayed());
            }
        }
    }
    public void validateEditIcon(){

        for (WebElement row : rows) {
            WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
            String celltext = cellEntry.getText();
            if (celltext.isEmpty()) {
                WebElement editIcon = row.findElement(By.xpath("//td[@class='edit-icon']"));
                Assert.assertFalse("Edit icon is not displayed ",editIcon.isEnabled());
            }
        }

    }
    public void verifyDeleteIcon(){

        for (WebElement row : rows) {
            WebElement cellEntry = row.findElement(By.xpath("//td[@class='delete-cell']"));
            String celltext = cellEntry.getText();
            if (!celltext.isEmpty()) {
                WebElement deleteIcon = row.findElement(By.xpath("//td[@class='delete-icon']"));
                Assert.assertTrue("Edit icon is displayed ",deleteIcon.isDisplayed());
            }
        }
    }
    public void validateDeleteIcon(){
        for (WebElement row : rows) {
            WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
            String celltext = cellEntry.getText();
            if (celltext.isEmpty()) {
                WebElement deleteIcon = row.findElement(By.xpath("//td[@class='delete-icon']"));
                Assert.assertFalse("Edit icon is not displayed ",deleteIcon.isEnabled());
            }
        }

    }
    public void validateSortIcon() {
        for (WebElement columnheader : columnheaders) {
            String columnText = columnheader.getText();
            if (!columnText.contains("Edit") && !columnText.contains("Delete")) {
                WebElement sortIcon = columnheader.findElement(By.xpath("//span[@class='sort-icon']"));
                Assert.assertTrue("Sort icon is displayed", sortIcon.isDisplayed());
            } else {
                LoggerLoad.info("The Sort icon is not displayed");
            }
        }
    }
    public void validatecheckbox(){
        for (WebElement row: rows){
            WebElement cellEntry = row.findElement(By.xpath("//td[@class='entry-cell']"));
            String cellText = cellEntry.getText();
            if(!cellText.isEmpty()){
                WebElement checkbox = row.findElement(By.xpath("//button[@id='checkbox']"));
                Assert.assertTrue("Checkbox is displayed", checkbox.isDisplayed());
            }
        }
    }
    public void validateFooter(){
    }
    public void pagination(){
        Assert.assertTrue("Pagination is displayed", pagination.isDisplayed());

    }
    public void footermessage(){
        Assert.assertTrue("Total number of attendances are displayed", footerMesg.isDisplayed());
        String Message= footerMesg.getText();
        LoggerLoad.info(Message);
    }
    }