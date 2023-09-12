package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DeleteAttendance5Page {
    public static WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();

    public DeleteAttendance5Page() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text()='NewAttendance')]")
    WebElement btnNewAttendance;
    @FindBy(id = "DeleteButton")
    WebElement deleteBtn;
    @FindBy(id = "YesButton")
    WebElement yesBtn;
    @FindBy(id = "NoButton")
    WebElement noBtn;
    WebElement checkbox = driver.findElement(By.xpath("//table[@id='dataTable']//tr[1]//input[@type='checkbox']"));
    @FindBy(xpath = "//table[@id='data-table']/tbody")WebElement Datatable;
    public void clickDeleteIcon(){
        deleteBtn.click();
    }
    public void checkAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
   public void verifyYesBtnText(){
        String alertText = yesBtn.getText();
       assert(alertText.contains("Yes"));
   }
public void verifyNoBtnText(){
    String alertText = noBtn.getText();
    assert(alertText.contains("No"));
}
public void alertPage(){
    deleteBtn.click();
    Alert alert = driver.switchTo().alert();
    System.out.println(alert.getText());
}
public void clickyesBtn(){
        yesBtn.click();
}
public void clicknoBtn(){
        noBtn.click();
}
public void verifySuccessMsg(){
    WebElement successMsg = driver.findElement(By.id("successMessage"));
    assertEquals("Deleted Successfully", successMsg.getText());
    }
public void redirectToAttendPage(){
    String title= driver.getTitle();
    assertEquals("Manage Attandance", title);
}
public void verifySingleRowCheckBx(){
                checkbox.click();
}
public void checkDeleteIconEnable(){
    WebElement deleteIcon = driver.findElement(By.cssSelector("deleteiconSelector"));
    if (deleteIcon.isDisplayed()) {
                if (deleteIcon.isEnabled()) {
                    System.out.println("Delete icon is displayed and enabled.");
        } else {
                      System.out.println("Delete icon is displayed but not enabled.");
        }
    } else {
               System.out.println("Delete icon is not displayed.");
    }
}
public void checktickmark(){
    assertTrue(checkbox.isSelected());
}
    public void selectRowLevelCheckboxes(List<String> checkboxLabels) {
        for (String label : checkboxLabels) {
            WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }}
    public void checkboxestickmarks() {
        boolean isChecked = checkbox.isSelected();
        assertTrue("Checkbox should be ticked", isChecked);
    }

    public void ValidateDeletion(){
        String mytitle = driver.getTitle();
        String title = "Manage Assignment Page";
        Assert.assertEquals(title, mytitle);
        String tableText = Datatable.getText();
        Assert.assertFalse("The selected row is deleted", Boolean.parseBoolean(tableText));
    }
    public void ValidatenonDeletion(){
        String mytitle = driver.getTitle();
        String title = "Manage Assignment Page";
        Assert.assertEquals(title, mytitle);
        String tableText = Datatable.getText();
        Assert.assertTrue("The selected row is not deleted", Boolean.parseBoolean(tableText));
    }
}
