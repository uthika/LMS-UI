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
public class Program2 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();


    public Program2() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Program']")
    WebElement buttonclick;

    public void button() {
        buttonclick.click();
    }

    @FindBy(xpath = "//*[@id= 'popup-heading']")
    WebElement popupheading;
    @FindBy(xpath = "//table[@id='data-table']/tbody/tr(0)")
    WebElement row;
    @FindBy(xpath = "//html/body")
    WebElement body;

    public void popup() {

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

    @FindBy(xpath = "//*[text()='Program name']")
    WebElement Programname;

    public void inputFields() {

        WebElement[] elementsToAssert = {
                Programname
        };

        for (WebElement element : elementsToAssert) {
            String elementName = element.getAttribute("name");
            Assert.assertTrue("The" + elementName + "is displayed", element.isDisplayed());
        }
    }

    public void radiobutton() {
        WebElement radioElement = driver.findElement(By.id("impressiveRadio"));
        boolean selectState = radioElement.isDisplayed();

//performing click operation only if element is not selected
        if (selectState == false) {
            radioElement.click();
        }
    }

    public void popupWithRowData() {
        String rowdata = row.getText();
        String Mainwindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        for (String win : set) {
            if (!Mainwindow.contentEquals(win)) {
                driver.switchTo().window(win);
                Assert.assertEquals(body.getText(), rowdata);
            }

        }

    }

    public void alert() {
        String expectedAlertMessage = "I am an alert box!";
        //Captured Alert Text (Actual Text)
        String actualAlertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
    }

    @FindBy(id = "Save")
    WebElement savebutton;

    public void Savebutton() {
        savebutton.click();
    }

    @FindBy(id = "Name")
    WebElement progname;

    public void Name() {
        progname.sendKeys("a");
        savebutton.click();
    }

    public void alertmsg() {
        WebElement element = driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.dismiss();
    }

    @FindBy(xpath = "//*[@id= 'popup-heading']")
    WebElement negmsg;

    public void alertmsgneg() {
        String alertText = negmsg.getText();
        System.out.println("Alert text is " + alertText);
    }

    @FindBy(id = "description")
    WebElement description;

    public void progdescription() {
        progname.sendKeys("a");
        savebutton.click();
    }

    public void alertmsgforstatus() {
        WebElement element = driver.findElement(By.id("description"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.dismiss();
    }
    @FindBy(xpath = "//*[@id= 'Name']")
    WebElement numbmsg;
    public void number() {

    }
    @FindBy(xpath = "//*[@id= 'Name']")
    WebElement CB;
    public void  Cancelbutton(){
       CB.click();
    }
    @FindBy(xpath = "//*[@id= 'Name']")
    WebElement CLICK;
    public void  CLICKbutton(){
        CLICK.click();
    }
  public void allfield(){
        negmsg.sendKeys("abc");
      description.sendKeys("abc");
      CLICK.click();
  }
}






