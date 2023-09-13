package com.pages;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import com.qa.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.*;
public class Program4 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    String rowText;
    @FindBy(xpath = "//table[@id='data-table']/tbody/tr(index)']")WebElement row;
    @FindBy(xpath = "//table[@id='data-table']/tbody/tr/'delete-button'")
    WebElement rowDel;
    public void rowDeletebutton() {
        rowText = row.getText();
        rowDel.click();
    }
    public void acceptAlert() {

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void validateNo(){
        Alert alert = driver.switchTo().alert();
        String alertmsg = alert.getText();
        Assert.assertTrue("the no button is displayed", alertmsg.contains("No"));

    }
    public void validateYes(){
        Alert alert = driver.switchTo().alert();
        String alertmsg = alert.getText();
        Assert.assertTrue("the yes button is displayed", alertmsg.contains("Yes"));

    }
    public void validateDialogBox(){
        Alert alert = driver.switchTo().alert();
        Assert.assertNotNull("The dialog box is dispalyed", alert);
    }
    public void validateDeleteAlert(){
        Alert alert = driver.switchTo().alert();
        String alertmsg = alert.getText();
        Assert.assertTrue("the delete alert is displayed", alertmsg.contains("delete"));

    }
    public void verifyDeletionAlertDisappears() {

        Alert deletionAlert = driver.switchTo().alert();
        deletionAlert.dismiss();

    }
    public void adminClicksCloseIconOnDeletionAlert() {
        By closeIconLocator = By.xpath("//div[@class='deletion-alert']//span[@class='close-icon']");
        WebElement closeIcon = driver.findElement(closeIconLocator);
        closeIcon.click();
    }








        }
