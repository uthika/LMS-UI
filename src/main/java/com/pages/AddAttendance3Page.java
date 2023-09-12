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

public class AddAttendance3Page {
    public static WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();

    public AddAttendance3Page() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text()='NewAttendance')]")
    WebElement btnNewAttendance;
    @FindBy(name="username")WebElement txtpname;
    @FindBy(name="username")WebElement txtcname;
    @FindBy(name="username")WebElement txtsname;
    @FindBy(name="username")WebElement txtattendance;
    @FindBy(name="username")WebElement txtattenddate;
    @FindBy(id = "save-button")
    WebElement saveBtn;
    public void setattendancedetails(String pname, String cname, String sname, String attend,String attenddate) {
        txtpname.sendKeys(pname);
        txtcname.sendKeys(cname);
        txtsname.sendKeys(sname);
        txtattendance.sendKeys(attend);
        txtattenddate.sendKeys(attenddate);
    }
    public void clickSaveBtn(){
        saveBtn.click();
    }
    public void verifysuccesswindow(){
        WebElement successMessage = driver.findElement(By.id("success-message"));
        String actualMsg = successMessage.getText();
        String expectedMsg = "Success!";
        assertEquals(actualMsg,expectedMsg);
    }
    public void verifyalertpopupwindow(String expectedMessage){
        WebElement errorMsg = driver.findElement(By.id("error-message"));
               String actualMessage = errorMsg.getText();
               assertEquals(expectedMessage, actualMessage);
    }
}
