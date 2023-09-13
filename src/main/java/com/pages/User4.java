package com.pages;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import com.qa.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.*;
public class User4 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();

    WebElement deleteButton = driver.findElement(By.id("deleteButton"));
    WebElement dataTable = driver.findElement(By.id("dataTable"));
    WebElement userRow = dataTable.findElement(By.xpath("//tr[contains(td,'John Doe')]"));
    public void clickDeleteIconForRow() {

        deleteButton.click();

    }

    public void handleDeleteConfirmationAlert() {
        Alert alert = driver.switchTo().alert();
    }

    public void clickYesOption() {
        WebElement yesButton = driver.findElement(By.xpath("//button[@id='yesButton']"));
        yesButton.click();
    }
    public void datatable(){
        boolean isUserListed = userRow.isDisplayed();

        // Use an assertion to verify that the user is still listed in the data table
        Assert.assertTrue("User is not listed in the data table", isUserListed);
    }
    List<WebElement> checkboxes = dataTable.findElements(By.xpath("//input[@type='checkbox']"));
public void Checkbox(){

    for (WebElement checkbox : checkboxes) {
        Assert.assertFalse("A checkbox is selected in the data table", checkbox.isSelected());
    }
}
    WebElement checkboxOrRow = driver.findElement(By.cssSelector("your-checkbox-selector-here"));
    public void checkbox1(){
        checkboxOrRow.click();
    }



    WebElement header = driver.findElement(By.cssSelector("your-header-selector-here"));
    public void header(){

        if (header.getText().equals(header)) {
           deleteButton.click();
        } else {
            System.out.println(header);
        }
    }
    public void verifyrowisdeleted(){
        boolean isRowDeleted = driver.findElements(By.cssSelector("your-row-identifier-selector-here")).isEmpty();
        Assert.assertTrue("The respective row in the data table is deleted", isRowDeleted);
    }
}























