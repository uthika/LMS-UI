package com.pages;
import com.qa.factory.*;
import com.qa.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import com.qa.factory.DriverFactory;
import com.qa.util.LoggerLoad;
import com.qa.util.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
import com.qa.util.*;
import org.openqa.selenium.*;

import java.util.*;

public class Program7 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    private CharSequence expectedString;
    @FindBy(xpath = "//button[text()='Assignment']")
    WebElement newAssignmentButton;
    @FindBy(xpath = "//cssSelector(.pagination.page-num")
    WebElement pageNumberElement;
    int rowCount;

    public void clickAssignmentButton() {
        newAssignmentButton.click();
        long endtime = System.currentTimeMillis();
        String Assignmentpage = driver.getTitle();
        String Title = "Manage Assignment Page";
        Assert.assertEquals(Title, Assignmentpage);

    }

    WebElement firstPageLink = driver.findElement(By.linkText("First page"));

    public void pagelink() {
        firstPageLink.click();
    }

    public void displayPage() {

        String pagenumber = pageNumberElement.getText();
        Assert.assertTrue("The page number is 1", pagenumber.contains("1"));

    }

    WebElement nextpage = driver.findElement(By.linkText("Next"));

    public void nxtPagedisabled() {
        if (rowCount < 5) {

            Assert.assertFalse("Next page is disabled", nextpage.isEnabled());
        }

    }

    public void VerifyPreviousPageRecord() {
        WebElement table = driver.findElement(By.id("tableId"));
        String expectedRecordText = "Expected Record Text";
        WebElement record = table.findElement(By.xpath("//tr[contains(text(), '" + expectedRecordText + "')]"));

    }

    public void previouspage() {
        driver.navigate().back();
    }

    public void paginationlink() {
        String linkTextToVerify = "Next";
        WebElement pagination = driver.findElement(By.cssSelector(".pagination"));

        boolean isLinkPresent = pagination.findElements(By.linkText(linkTextToVerify)).size() > 0;

    }

    public void Lastpagelink() {
        WebElement lastPageLink = driver.findElement(By.linkText("Last"));
        lastPageLink.click();
    }

    public void lastpage() {
        String lastPageUrl = "https://example.com/last-page";
    }
    public void startpagelink() {
        WebElement startPageLink = driver.findElement(By.linkText("Start page"));
        startPageLink.click();
    }
}






