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
public class User2 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    private CharSequence expectedString;

    public void String() {
        WebElement fieldElement = driver.findElement(By.xpath("//input[@name='fieldName'] "));
        if (fieldElement != null) {
            System.out.println("exists in the pop-up.");
        } else {
            System.out.println("does not exist in the pop-up.");
        }
    }

    public void verifyNewUserInDataTable() {
        WebElement dataTable = driver.findElement(By.id("userTable"));
        WebElement newUserRow = dataTable.findElement(By.xpath("//tr[contains(., 'NewUser')]"));
        Assert.assertTrue(newUserRow.isDisplayed());
    }

    public void fieldvalue() {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneNumberField = driver.findElement(By.id("phoneNumber"));
        WebElement submitButton = driver.findElement(By.id("submitButton"));

        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        emailField.sendKeys("johndoe@example.com");
        phoneNumberField.sendKeys("1234567890");
        submitButton.click();
    }

    public void invalidvalue() {
        WebElement inputElement = driver.findElement(By.name("q"));
        inputElement.sendKeys("Selenium WebDriver");
    }

    public void errorMessageShouldAppear() {

        WebElement errorMessageElement = driver.findElement(By.cssSelector(".error-message"));
        Assert.assertTrue(errorMessageElement.isDisplayed());
    }

    public void checkForBlankMandatoryFields() {
        List<By> mandatoryFieldLocators = List.of(
                By.id("field1"),
                By.name("field2"),
                By.xpath("//input[@placeholder='Mandatory Field']"));
        for (By locator : mandatoryFieldLocators) {
            WebElement fieldElement = driver.findElement(locator);
            String fieldValue = fieldElement.getAttribute("value");
        }
    }
}
