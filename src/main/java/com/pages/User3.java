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
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.util.*;
public class User3 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    WebElement editIcon = driver.findElement(By.xpath("//table[@id='dataTableId']//tr[ rowNumberToCheck  ]//td[@class='edit-icon']"));
    

    public void editicononrow() {
        // Locate the edit icon element for the specified row

        boolean isEditIconEnabled = editIcon.isEnabled();
        if (isEditIconEnabled) {
            System.out.println("Edit icon is enabled for row ");
        } else {
            System.out.println("Edit icon is not enabled for row ");
        }
    }

    public void click() {
        editIcon.click();
    }

    public void popup() {
        By userDetailsPopUpLocator = By.id("userDetailsPopUpId");
        WebElement userDetailsPopUp = (WebElement) ExpectedConditions.presenceOfElementLocated(userDetailsPopUpLocator);
        if (userDetailsPopUp.isDisplayed()) {
            System.out.println("User details pop-up is displayed.");
        } else {
            System.out.println("User details pop-up is not displayed.");
        }
    }

    public void submitclick() {
        WebElement submitButton = driver.findElement(By.id("submitButtonId"));
        submitButton.click();
    }

    WebElement dataTable = driver.findElement(By.id("dataTableId"));
    WebElement updatedRow = dataTable.findElement(By.xpath("//tr[contains(td[1], 'John') and contains(td[2], 'Doe')]"));

    public void updaterow() {

        if (updatedRow != null) {
            System.out.println("Updated user details appear in the data table.");
        } else {
            System.out.println("Updated user details do not appear in the data table.");
        }
    }
    public void verifyerrormsg() {
        WebElement errorMessage = driver.findElement(By.id("error-message-id"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Error message is displayed");

        } else {
            System.out.println("Error message is not displayed");

        }
    }
    public void eraseDataFromDescriptionField() {
        WebElement descriptionField = driver.findElement(By.id("description-field-id"));
        descriptionField.clear();
    }




}








