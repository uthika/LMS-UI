package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class Class6 {

	WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    String text;

    public Class6() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//button[@id='checkbox']") WebElement checkbox;
    @FindBy(xpath="//button[text()='DeleteClass']") WebElement deleteClassButton;
    @FindBy(xpath="//'datatable']") WebElement Dt;
    @FindBy(id="Checkbox") WebElement HeaderCheckbox;
    @FindBy(css = ".button") WebElement deleteIcon;
    List<WebElement> rows = driver.findElements(By.xpath("//'datatable']"));
    
    public void singleCheck()
    {
    	checkbox.click();
    }
    public void deleteIcEnbld()
    {
    	 Assert.assertTrue("Delete icon is enabled ",deleteIcon.isEnabled());
    }
    
    
    public void multiCheck()
    {
    	HeaderCheckbox.click();
    }
    
    public void enbldbox()
    {
    for (WebElement row: rows)
	 {
	        WebElement cellval = row.findElement(By.xpath("//td[@class='entry-cell']"));
	        String cellText = cellval.getText();
	        if(!cellText.isEmpty())
	        {
	            WebElement checkbox = row.findElement(By.xpath("//button[@id='checkbox']"));
	            Assert.assertTrue("Checkbox is displayed", checkbox.isEnabled());
	        }
	    }
    }
    public void ManageClassvalidton()
    {
    	 String mytitle = driver.getTitle();
         String title = "Manage Classes Page";
         Assert.assertEquals(title, mytitle);
         String Text = Dt.getText();
         Assert.assertFalse("Successfully deleted", Text.contains(text));
    }
    
}
