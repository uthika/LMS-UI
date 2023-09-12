package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class EditAttendance4Page {
    public static WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    long endtime, starttime;

    public EditAttendance4Page() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "EditButton")
    WebElement editBtn;
    @FindBy(id = "SaveButton")
    WebElement saveBtn;
    @FindBy(id = "ClassTextBox")
    WebElement classtxtbox;
    @FindBy(id = "ProgramTextBox")
    WebElement prgmtxtbox;
    @FindBy(id = "StudentTextBox")
    WebElement stutxtbox;
    @FindBy(id = "AttendanceTextBox")
    WebElement attendtxtbox;
    @FindBy(id = "DateTextBox")
    WebElement datetxtbox;
        public void clickEditBtn(){
        editBtn.click();
        classtxtbox.clear();
        classtxtbox.sendKeys("Tabelau");
        saveBtn.click();
    }
    public void verifysuccesswindow(){
        WebElement successMessage = driver.findElement(By.id("success-message"));
        String actualMsg = successMessage.getText();
        String expectedMsg = "Success!";
        assertEquals(actualMsg,expectedMsg);
    }
    public void updatefields1(){
        editBtn.click();
        prgmtxtbox.clear();
        classtxtbox.sendKeys("Tabelau");
        saveBtn.click();
    }
    public void checkwarnmsg(){
        WebElement warnMessage = driver.findElement(By.id("warn-message"));
        String actualMsg = warnMessage.getText();
        String expectedMsg = "Fill out all fields!";
        assertEquals(actualMsg,expectedMsg);
    }
    public void updatefields2(){
        editBtn.click();
        classtxtbox.clear();
        prgmtxtbox.sendKeys("aug23-Sdet-058");
        saveBtn.click();
    }
    public void updatefields3(){
        editBtn.click();
        stutxtbox.clear();
        classtxtbox.sendKeys("web testing");
        saveBtn.click();
    }
    public void updatefields4(){
        editBtn.click();
        attendtxtbox.clear();
        stutxtbox.sendKeys("malar");
        saveBtn.click();
    }
    public void updatefields5(){
        editBtn.click();
        datetxtbox.clear();
        classtxtbox.sendKeys("selenium");
        saveBtn.click();
    }
}
