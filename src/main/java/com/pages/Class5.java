package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;

public class Class5 {

    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    String text;

    public Class5() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//text()='Editclass']") WebElement editNewClass;
    @FindBy(xpath = "//'confirm") WebElement rowDelete;   
    @FindBy(xpath = "id='body']") WebElement field;
    @FindBy(xpath="//'datatable']") WebElement Dt;
    @FindBy(xpath = "//button[text()='Delete']") WebElement DeleteIcon;

    public void deleteRow() 
    {
        text = field.getText();
        rowDelete.click();
    }
    
    public void alertValidate() 
    {
    	  Alert alert = driver.switchTo().alert();
          Assert.assertNotNull("Alert is dispalyed", alert);
    }
    
    public void acceptYesButton()
    {
           Alert alert = driver.switchTo().alert();
           String alertmessage = alert.getText();
           Assert.assertTrue("Accept yes button", alertmessage.contains("Yes"));
    }
    
    public void rejectNoButton()
    {
    	   Alert alert = driver.switchTo().alert();
           String alertmessage = alert.getText();
           Assert.assertTrue("Accept no button", alertmessage.contains("No"));
    }
    public void deleteAlert()
    {  
    	Alert alert = driver.switchTo().alert();
        String alertmsg = alert.getText();
        Assert.assertTrue("Delete alert", alertmsg.contains("delete"));	
    }
    
    public void clickYes()
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    public void successValidation()
    {
    	 String mytitle = driver.getTitle();
         String title = "Manage Classes Page";
         Assert.assertEquals(title, mytitle);
         String Text = Dt.getText();
         Assert.assertFalse("Successfully deleted", Text.contains(text));
    }
    
    public void clickNo()
    {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    
    public void validateDeletion()
    {
        String mytitle = driver.getTitle();
        String title = "Manage Classes Page";
        Assert.assertEquals(title, mytitle);
        String Text = Dt.getText();
        Assert.assertTrue("Not deleted", Text.contains(text));
    }
    
}
