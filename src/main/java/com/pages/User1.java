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
public class User1 {
    WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    private CharSequence expectedString;

    public void navigation()
   {
        // Assuming the navigation bar is a <ul> element with <li> items
        WebElement navigationBarElement = driver.findElement(By.cssSelector("ul.navigation-bar"));

        // Locate the specific element within the navigation bar by its text
        WebElement elementToClick = navigationBarElement.findElement(By.xpath(".//li[contains(text()= elementText "));

        // Click on the element
        elementToClick.click();
    }
    public void string() {

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Expected string not found in the URL", true, currentUrl.contains(expectedString));
    }
    public void header(){
        WebElement headerElement = driver.findElement(By.cssSelector("your-header-css-selector"));
        String headerText = headerElement.getText();
        Assert.assertTrue("Expected string not found in the header", headerText.contains(expectedString));
    }
    public void pagination(){
        WebElement paginationContainer = driver.findElement(By.id("pagination-container"));

        Assert.assertTrue("Pagination controls are not visible", paginationContainer.isDisplayed());
    }
    public void headerdisplay() {
       WebElement data_table = driver.findElement(By.xpath( "//table[@id='data-table']"));
       List <WebElement> table_headers = data_table.findElements(By.cssSelector("th"));
        String[] expectedHeaders = {"Id", "Name", "Location", "Phone Number", "Edit/Delete"};
        for (String header : expectedHeaders) {
            boolean headerFound = false;
            for (WebElement tableHeader : table_headers) {
                if (tableHeader.getText().trim().equals(header)) {
                    headerFound = true;
                    break;
                }
            }
            if (!headerFound) {
                System.out.println("Header '" + header + "' not found in the table.");
            }
        }
    }
   public void buttondisable(){
       WebElement iconButton = driver.findElement(By.xpath("//button[contains(text(), buttonTextToCheck)]"));

       // Check if the icon button is disabled
       boolean isDisabled = iconButton.getAttribute("disabled") != null;

       if (isDisabled) {
           System.out.println("' icon button is disabled.");
       } else {
           System.out.println( "' icon button is not disabled.");
       }
   }
   public void stringbutton(){
       String buttonTextToVerify = "Button Text";

       // Locate the button by its text
       WebElement button = driver.findElement(By.xpath("//button[text()='" + buttonTextToVerify + "']"));

       // Check if the button is displayed
       if (button.isDisplayed()) {
           System.out.println("The '" + buttonTextToVerify + "' button is displayed.");
       } else {
           System.out.println("The '" + buttonTextToVerify + "' button is not displayed.");
       }
   }
  public void searchtextbox(){
      WebElement searchBox = driver.findElement(By.id("search-box"));
      if (searchBox.isDisplayed()) {
          System.out.println("The search text box is displayed.");
      } else {
          System.out.println("The search text box is not displayed.");
      }
  }
  public void checkbox(){
      List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='data-table']//tr")); // Adjust the selector as needed

      boolean allRowsHaveCheckboxes = true;

      // Iterate through each row and verify the presence of a checkbox
      for (WebElement row : tableRows) {
          List<WebElement> checkboxes = row.findElements(By.tagName("input"));
          boolean rowHasCheckbox = false;

          for (WebElement checkbox : checkboxes) {
              if (checkbox.getAttribute("type").equalsIgnoreCase("checkbox")) {
                  rowHasCheckbox = true;
                  break;
              }
          }
          if (!rowHasCheckbox) {
              allRowsHaveCheckboxes = false;
              break;
          }
      }
      if (allRowsHaveCheckboxes) {
          System.out.println("Each row in the data table has a checkbox.");
      } else {
          System.out.println("Not all rows in the data table have checkboxes.");
      }
  }
   public void deleteicon(){
       List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='data-table']//tr"));

       boolean allRowsHaveEnabledDeleteIcons = true;

       for (WebElement row : tableRows) {
           List<WebElement> deleteIcons = row.findElements(By.xpath(".//i[@class='delete-icon' and not(@disabled)]"));
           boolean rowHasEnabledDeleteIcon = !deleteIcons.isEmpty();

           if (!rowHasEnabledDeleteIcon) {
               allRowsHaveEnabledDeleteIcons = false;
               break;
           }
       }
   }

   public void button(){
       WebElement button = driver.findElement(By.cssSelector("button#example-button"));
       button.click();
   }

   public void userdetails(){
           WebElement popup = driver.findElement(By.id("popup-id"));
          Assert.assertTrue("The pop-up with user details is not displayed", popup.isDisplayed());

       }
}






















