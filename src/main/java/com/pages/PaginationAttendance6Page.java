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

public class PaginationAttendance6Page {
    public static WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    public PaginationAttendance6Page() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@id='data-table']/tbody/th/tr']")
    WebElement rowHeader;
    @FindBy(xpath = "//table[@id='data-table']/tbody")
    WebElement Datatable;
    @FindBy(xpath = "//cssSelector(.pagination.page-num")
    WebElement pageNumberElement;
    @FindBy(xpath = "//button[@id='Pagination']")
    WebElement pagination;
    @FindBy(xpath = "//a[@class='next']")
    WebElement rArrow;
    @FindBy(xpath = "//a[@class='next']")
    WebElement lArrow;
    @FindBy(xpath = "//button[contains(text()='Attendance')]")
    WebElement btnAttendance;
    @FindBy(xpath = "//a[@class='next-page']")
    WebElement nextpage;
    int rowCount;
    public void dashboard() {
        String dashboardURL = prop.getProperty("DashBoardURl");
        driver.get("DashBoardURl");
        long starttime = System.currentTimeMillis();
        String mytitle = driver.getTitle();
        String title = "DashBoard Page";
        Assert.assertEquals(title, mytitle);
    }
    public void clickAttendanceButton() {
        btnAttendance.click();
        long endtime = System.currentTimeMillis();
    }
    public void displayPage() {

        String pagenumber = pageNumberElement.getText();
        Assert.assertTrue("The page number is 1", pagenumber.contains("1"));

    }

    public void rightArrowEnabled() {

        List<WebElement> tablerows = Datatable.findElements(By.xpath("//table[@id='data-table']/tbody/th/tr']"));
        rowCount = tablerows.size();
        if (rowCount > 5) {
            Assert.assertTrue("Right arrow is enabled", rArrow.isEnabled());
        }
    }

    public void leftArrowdisabled() {

        List<WebElement> tablerows = Datatable.findElements(By.xpath("//table[@id='data-table']/tbody/th/tr']"));
        rowCount = tablerows.size();
        if (rowCount > 5) {
            Assert.assertFalse("left arrow is disabled", lArrow.isEnabled());
        }
    }

    public void secondRightArrowEnabled() {
        if (rowCount > 10) {
            rArrow.click();
            Assert.assertTrue("Right arrow is enabled", rArrow.isEnabled());
        }
    }

    public void secondleftArrowEnabled() {
        if (rowCount > 10) {
            rArrow.click();
            Assert.assertTrue("Right arrow is enabled", lArrow.isEnabled());
        }

    }

    public void rightArrowdisabled() {
        rArrow.click();
        List<WebElement> tablerows = Datatable.findElements(By.xpath("//table[@id='data-table']/tbody/th/tr']"));
        rowCount = tablerows.size();
        if (rowCount < 10) {
            Assert.assertFalse("Right arrow is disabled", lArrow.isEnabled());
        }
    }

    public void pginationenabled() {
        if (rowCount > 5) {
            Assert.assertTrue("Pagination controls are enabled", pagination.isEnabled());
        }
    }

    public void pginationdisabled() {
        if (rowCount < 5) {
            Assert.assertFalse("Pagination controls are disabled", pagination.isEnabled());

        }
    }

    public void nxtPageEnabled(){
        if(rowCount>5){

            Assert.assertTrue("Next page is enabled", nextpage.isEnabled());
        }

    }

    public void nxtPagedisabled(){
        if(rowCount<5){

            Assert.assertFalse("Next page is disabled", nextpage.isEnabled());
        }

    }
}
