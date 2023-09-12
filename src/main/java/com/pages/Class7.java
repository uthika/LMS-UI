package com.pages;

import com.qa.factory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Class7 {

	WebDriver driver;
    List<String> org;
    List<String> expected;

    public Class7() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "row1']") WebElement sortHeader;
    @FindBy(id = "tags-div")  WebElement sort;

    public void sortingHeader ()
    {
    	List<WebElement> cells = driver.findElements(By.id("row1"));
        List<String> col = new ArrayList<>();
        for (WebElement col1 : cells) {
            col.add(col1.getText());
        }
        org = new ArrayList<>(col);
        org.sort(Collections.reverseOrder());
        sortHeader.click();
    }
    
    
    public void desOrder()
    {
    	List<WebElement> cell1 = driver.findElements(By.id("row1"));
        List<String> sorteddata = new ArrayList<>();
        for (WebElement cell : cell1) {
            sorteddata.add(cell.getText());
        }
        expected = new ArrayList<>(sorteddata);
        Assert.assertEquals("Sorting in descending order", expected, org);

    	
    }
    public void columnHeader()
    {
    	  Actions action = new Actions(driver) ;
          action.doubleClick(sortHeader).perform();
    }
    public void ascOrder()
    {
        List<WebElement> cell2 = driver.findElements(By.id("tags-div"));
        List<String> cell1 = new ArrayList<>();
        for (WebElement cell : cell2) {
            cell1.add(cell.getText());
        }
        List<String> sorted = new ArrayList<>(cell1);
        Collections.sort(expected);

        Assert.assertEquals("Sorted in ascending order", expected, sorted);
    }
}
