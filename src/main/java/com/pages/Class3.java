package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.Set;


public class Class3 {
	WebDriver driver;

    public Class3() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
	    
	    ConfigReader CR = new ConfigReader();
	    Properties prop = CR.init_prop();
	    ExcelReader reader = new ExcelReader();
	    
	     @FindBy(xpath = "//button[dropdown()='batch']") WebElement staticDropdown;
	     @FindBy(xpath="//select[@name='Batch']") WebElement ddBatch;
	     @FindBy(xpath="//select[@name='staff']") WebElement ddStaff;
	     @FindBy(xpath="//select[@name='Noclass']") WebElement classNo;
	     @FindBy(xpath="//select[@name='Classdate']") WebElement classdate;
		 @FindBy(id="@savButton") WebElement savButton;
		 @FindBy(id="@cancelButton") WebElement canButton;
		 @FindBy(xpath = "//*[@id='calenderIcon']") WebElement calender;
		 @FindBy(xpath = "//[@class='rightarrow']") WebElement RtArrow;
		 @FindBy(xpath = "//[@class='leftarrow']") WebElement LtArrow;
		 @FindBy(xpath = "//[@class='nextmonth']") WebElement nextMonth;
		 @FindBy(xpath = "//[@class='previousmonth']") WebElement previousMonth;
		 @FindBy(xpath = "//['currentdate']") WebElement currentDate;
         @FindBy(xpath = "//['futuredate']") WebElement futureDate;
         @FindBy(xpath = "//td[@data-day='*']") WebElement specificdate;
		
	     public void ddBatchId() {
	    	 ddBatch.click(); 
	     }

	     public void ddBatchID() {
	    	 Select dropdown = new Select(staticDropdown);
	    	 dropdown.selectByIndex(1);
	    	 System.out.println(dropdown.getFirstSelectedOption().getText()); 
	     }
	     
	     public void dataentryAdd(String sheetName, int rowNumber) {
	    	 String ExcelPath = prop.getProperty("ExcelSheet");
	    	 try {
				List<Map<String, String>> testdata = reader.getData(ExcelPath, sheetName);
				
				String addBatchId  =testdata.get(rowNumber).get("Batch ID");
				String addNoClasses  =testdata.get(rowNumber).get("No of Clases");
				String addClassDate =testdata.get(rowNumber).get("Class Date");
				String addStaffId  =testdata.get(rowNumber).get("Staff Id");
				
				System.out.println(testdata);
			} catch (InvalidFormatException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    	 
	     }
	          public void datavalidaddmsg() {
	    	     savButton.click();
	    	     String Expectedmsg = driver.getTitle();
	    	     String actual = "success" ;
	    	     Assert.assertEquals("new class details is added" + Expectedmsg, actual);
	      }
	        
	          public void errorMsg()
	          {
	        	     savButton.click();
		    	     String Expectedmsg = driver.getTitle();
		    	     String actual = "success" ;
		    	     Assert.assertEquals(" Invalid data error message appears" + Expectedmsg, actual);
	          }
	           
	          public void datePicker()
	          {
	        	  calender.click();
	        	  specificdate.click();
	          }
	          
	          public void validatedate()
	          {
	        	  Assert.assertTrue("Selected date is shown", specificdate.isDisplayed());
	          }
	     
	          public void formatDate()
	          {
	        	  String regex = "\\d{2}/\\d{2}/\\d{4}";
	              String actualDate = specificdate.getText();
	              Pattern pattern = Pattern.compile(regex);
	              java.util.regex.Matcher matcher = pattern.matcher(actualDate);
	              boolean isDateFormatValid = matcher.matches();
	              Assert.assertTrue("Date format displayed is mm/dd/yyyy ", isDateFormatValid);
	          }
	          public void DatepickerRarrow()
	          {
	              calender.click();
	              RtArrow.click();
	          }
	          
	          public void nextMonth() 
	          {

	              Assert.assertTrue("Next month is displayed",nextMonth.isDisplayed() );

	          }

	          public void DatepickerLArrow() 
	          {
	              calender.click();
	              LtArrow.click();
	          }
	          
	          public void prevMonth() {

	              Assert.assertTrue("Previous month is displayed",previousMonth.isDisplayed() );

	          }

	          public void dataPickerButton(){
	              calender.click();
	          }
	          
	          public void currentdate(){
	              Assert.assertTrue("The current date is highlighted", currentDate.isEnabled());

	           }
	           public void futuredate() {
	               calender.click();
	               RtArrow.click();
	               nextMonth.click();
	               specificdate.isSelected();
	           }

	           public void selecteddate()
	           {
	               Assert.assertTrue("The current date is highlighted", specificdate.isEnabled());

	           }

	           public void cancelEmpty(){
	               canButton.click();
	           }
		 
	           public void ClassPage(){
	               String actual = driver.getTitle();
	               String expected = "Manage Classes Page";
	               Assert.assertEquals(expected, actual);
	           }
}