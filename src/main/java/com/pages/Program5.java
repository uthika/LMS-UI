package com.pages;
import org.junit.*;
import org.openqa.selenium.*;
import com.qa.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.*;
public class Program5 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    By checkboxLocator = By.xpath("//input[@type='checkbox']");
    @FindBy(xpath = "//table[@id='data-table']/tbody/tr(index)']")WebElement row;
 List<WebElement>checkboxes=driver.findElements(checkboxLocator);
    WebElement dataTable = driver.findElement(By.id("dataTable"));
    public void deletealert(){
        Alert confirmationAlert = driver.switchTo().alert();
    }

    public void Checkbox(){

        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse("A checkbox is selected in the data table", checkbox.isSelected());
        }
    }
    public void clickYesOption() {
        WebElement yesButton = driver.findElement(By.xpath("//button[@id='yesButton']"));
        yesButton.click();
    }
    public void clicknoOption() {
        WebElement noButton = driver.findElement(By.xpath("//button[@id='yesButton']"));
        noButton.click();
    }

    public void verifydelete(){
        WebElement deleteOption = driver.findElement(By.xpath("//div[@id='manage-program']//button"));

        // Verify if the "Delete" option is enabled
        boolean isEnabled = deleteOption.isEnabled();
    }
    public void rowDeletebutton() {
        String rowText = row.getText();

    }
    public void ValidateDeletion(){

        String mytitle = driver.getTitle();
        String title = "Manage Assignment Page";
        Assert.assertEquals(title, mytitle);
        String tableText = dataTable.getText();



    }
    public void ValidatenonDeletion(){

        String mytitle = driver.getTitle();
        String title = "Manage Assignment Page";
        Assert.assertEquals(title, mytitle);
        String tableText = dataTable.getText();


    }

}
