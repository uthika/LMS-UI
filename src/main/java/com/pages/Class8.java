package com.pages;

import com.qa.factory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class Class8 {
	    WebDriver driver;

	    public Class8() {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(id = "row1']") WebElement sortHeader;
	    @FindBy(xpath = "//id=table") WebElement Dt;
	    @FindBy(xpath = "(pagenumber") WebElement pageNum;
	    @FindBy(xpath = "'pagination']") WebElement pagin;
	    @FindBy(xpath = "//['rightarrow']") WebElement rightArrow;
	    @FindBy(xpath = "//['leftarrow']") WebElement leftArrow;
	    @FindBy(xpath = "//['nextPage']") WebElement nextPage;
	    int rowCount;

	    public void RightdispPage()
	    {
        List<WebElement> tablerows = Dt.findElements(By.xpath("id = \"row1']\""));
        rowCount = tablerows.size();
        if (rowCount > 5) 
        {
            Assert.assertTrue("Right arrow is enabled", rightArrow.isEnabled());
        }
	    }
	    
	    public void leftdispPage()
	    {
	    	List<WebElement> tablerows = Dt.findElements(By.xpath("id = \"row1']\""));
	        rowCount = tablerows.size();
	        if (rowCount > 5) 
	        {
	            Assert.assertFalse("Left arrow is disabled",leftArrow.isEnabled());
	        }
	    	
	    }
	    public void RightEnbld()
	    {
	    	 if (rowCount > 10) {
	             rightArrow.click();
	             Assert.assertTrue("Second right arrow is enabled", rightArrow.isEnabled());
	         }
	    }
	    public void LeftEnbld()
	    {
	    	 if (rowCount > 10) {
	             leftArrow.click();
	             Assert.assertTrue("Second left arrow is enabled", leftArrow.isEnabled());
	         }
	    }
	    public void displayPage()
	    {
	    	  rightArrow.click();
	          List<WebElement> tablerows = Dt.findElements(By.xpath("id = \"row1']\""));
	          rowCount = tablerows.size();
	          if (rowCount < 10) {
	              Assert.assertFalse("Right arrow is disabled", rightArrow.isEnabled());
	    }
	    }
	    public void enbldpag()
	    {
	    	if (rowCount > 5)
	    	{
	            Assert.assertTrue("Pagination is enabled", pagin.isEnabled());
	        }
	    }
	    public void disbldpag()
	    {
	    	if (rowCount < 5) 
	    	{
	            Assert.assertFalse("Pagination is disabled", pagin.isEnabled());

	        }
	    }
	    public void enbldnxtPage()
	    {
	    if (rowCount>5)
	    {

            Assert.assertTrue("Next page is enabled", nextPage.isEnabled());
        }
	    }
	    public void disbldNxtPage()
	    {
	    	 if(rowCount<5)
	    	 {

	             Assert.assertFalse("Next page is disabled", nextPage.isEnabled());
	         }
	    }

}
