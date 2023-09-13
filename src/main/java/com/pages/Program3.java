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

import java.util.*;
public class Program3 {

    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    @FindBy(id = "EditButton")
    WebElement editBtn;
    @FindBy(xpath = "//*[@id= 'popup-heading']")
    WebElement popupheading;

    public void Editbutton() {
        editBtn.click();
    }

    public void editPopup() {
        String Mainwindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        for (String win : set) {
            if (!Mainwindow.contentEquals(win)) {
                driver.switchTo().window(win);
                String popupheadingText = popupheading.getText();
                String expectedheading = "Assignment Details";
                Assert.assertEquals(expectedheading, popupheadingText);
                LoggerLoad.info("Popup window is displayed");

            }
        }
    }

    public void adminEditsNameColumnAndClicksSave() {
        WebElement nameColumn = driver.findElement(By.xpath("//tr[1]/td[2]"));

        nameColumn.click();
        nameColumn.clear();
        nameColumn.sendKeys("NewName");
        WebElement saveButton = driver.findElement(By.id("saveButton"));
        saveButton.click();
    }

    public void verifyMessageAlertAndUpdatedName(String expectedMessage) {
        WebElement messageAlert = driver.findElement(By.id("messageAlert"));
        Assert.assertEquals(expectedMessage, messageAlert);
    }

    public void adminChangesStatusAndClicksSave() {
        WebElement statusDropdown = driver.findElement(By.id("statusDropdown"));
        statusDropdown.click();
        WebElement newStatusOption = driver.findElement(By.xpath("//option[text()='New Status']"));
        newStatusOption.click();
        WebElement saveButton = driver.findElement(By.id("saveButton"));
        saveButton.click();
    }
    public void verifyMessageAlertAndUpdatedStatus(String expectedMessage) {

        WebElement messageAlert = driver.findElement(By.id("messageAlert"));
        String actualMessage = messageAlert.getText();

        // Verify that the message alert matches the expected message
        Assert.assertEquals(expectedMessage, actualMessage);

    }
    public void adminEditsDescriptionAndClicksSave() {

        WebElement descColumn = driver.findElement(By.id("descColumnId"));
        descColumn.click();
        WebElement descInputField = driver.findElement(By.id("descInputFieldId"));
        descInputField.clear();
        descInputField.sendKeys("New Description");
        WebElement saveButton = driver.findElement(By.id("saveButtonId"));
        saveButton.click();
    }
    public void adminClicksSaveButtonOnEditPopup() {

        WebElement saveButton = driver.findElement(By.id("saveButtonId"));
        saveButton.click();
    }
    public void verifyPopupDisappearsAndNothingChanged() {

        WebElement isPopupVisible = driver.findElement(By.id("programDetailsPopupId"));
        Assert.assertFalse(true);
        WebElement programRow = driver.findElement(By.xpath("//tr[contains(text(),'Program Name')]"));
        String programDetails = programRow.getText();
    }


    public void adminClicksCancelButtonOnEditPopup() {
        WebElement cancelButton = driver.findElement(By.id("cancelButtonId"));
        cancelButton.click();
    }
    public void verifyErrorMessageAlert() {
        // Check if an alert is displayed (assumed to be an error message)
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
    }
    public  void Adminvalidation () {
        WebElement nameInput = driver.findElement(By.id("nameInputId"));
        WebElement descInput = driver.findElement(By.id("descInputId"));

        nameInput.sendKeys("123");
        descInput.sendKeys("$$");

    }
    public void  msgalert(){
        WebElement statusElement = driver.findElement(By.id("statusElementId"));
        String updatedStatus = statusElement.getText();
        String expectedUpdatedStatus = "Completed";
        if (updatedStatus.equals(expectedUpdatedStatus)) {
            System.out.println("Status in the table is updated as expected: " + updatedStatus);
        } else {
            System.out.println("Status in the table is not updated as expected: " + updatedStatus);
        }
    }
}
