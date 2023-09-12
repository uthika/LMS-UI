package com.pages;

import java.util.Properties;
import java.util.Set;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.LoggerLoad;

public class Class4 {
	WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    JSONReader jsonreader = new JSONReader();
    String filepath = prop.getProperty("TestjsonPath");
    JsonObject jsondata = jsonreader.readJsonData(filepath);

    public Class4() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='EditClass']") WebElement editClass;
    @FindBy(xpath = "//[id'popup-heading']") WebElement popClassedit;
    @FindBy(xpath = "//table[id'datatable']'editButton'") WebElement Classeditrow;
    @FindBy(xpath = "container") WebElement container;
    @FindBy(xpath = "//id='Row'") WebElement row;
    
        public void classEdit()
        {
        	editClass.click();
        }
        public void editPopUp()
        {
            String Mainwindow = driver.getWindowHandle();
            Set<String> set = driver.getWindowHandles();
            for (String window : set) {
                if (!Mainwindow.contentEquals(window))
                   {
                    driver.switchTo().window(window);
                    String headingTit = popClassedit.getText();
                    String expectedmessage = "Class Details";
                    Assert.assertEquals(expectedmessage, headingTit);
                    LoggerLoad.info("Popup window is displayed");

                   }
            }
        }
        
        public void ClassEditrow() 
        {
        	Classeditrow.click();

        }

        public void ClassEditrowPopup() 
        {
            String rowdata = row.getText();
            String Mainwindow = driver.getWindowHandle();
            Set<String> set = driver.getWindowHandles();
            for (String window : set) {
                if (!Mainwindow.contentEquals(window)) {
                    driver.switchTo().window(window);
                    Assert.assertEquals(container.getText(), rowdata);
                }
            }
        }
        
         public void updatedData()
         {
        	 JsonArray validData = jsondata.getAsJsonArray("Valid Data");
             JsonObject clasName = validData.get(0).getAsJsonObject();
             String data = clasName.getAsString();
             String tabledata = row.getText();
             Assert.assertEquals(tabledata,data);
         }
}
