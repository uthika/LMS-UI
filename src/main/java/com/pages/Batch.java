package com.pages;


import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.google.gson.JsonArray;
import com.qa.util.ConfigReader;
import com.qa.util.JSONReader;
import com.qa.util.LoggerLoad;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;

public class Batch  {
	WebDriver driver;
    ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
    long endtime, starttime;
    String rowText;
    JSONReader jsonreader = new JSONReader();
    String filepath = prop.getProperty("TestdataPath");
    //JsonObject jsondata = jsonreader.readJsonData(filepath);

	
	@FindBy(xpath="//a[text()='batch']")WebElement batch;
	 @FindBy(xpath = "//header[@id='header-id']") WebElement Header;
	 @FindBy(xpath = "//button[@id='Pagination']") WebElement pagination;    
	 @FindBy(xpath = "//button[@id='checkbox']")WebElement checkbox;
	 @FindBy(xpath = "//header[text()='Batch name']") WebElement Batchname;
	 @FindBy(xpath = "//header[text()='Batch Description']") WebElement BatchDescription;
	 @FindBy(xpath = "//header[text()='Batch status']]")WebElement Batchstatus;
	 @FindBy(xpath = "//header[text()='Noofclasses']]")WebElement Noofclasses;
	 @FindBy(xpath = "//header[text()='Edit delete']]")WebElement editdel;
	 @FindBy(xpath = "//header[text()='programname']]")WebElement progname;
	 @FindBy(xpath = "//header[text()='deleteico']]")WebElement deleteicon;
	 @FindBy(xpath = "//header[text()='newbatch']]")WebElement newbatch;
	 @FindBy(xpath="(//td[@name='table']")WebElement checkcheckbox;
	 @FindBy(xpath="(//td[@name='table']")WebElement popupheading;
	 @FindBy(id="name")WebElement popName;
	 @FindBy(id="des")WebElement popDes;
	 @FindBy(id="pname")WebElement popProName;
	 @FindBy(id="active")WebElement popactive;
	 @FindBy(id="inactive")WebElement popinactive;
	 @FindBy(id="send")WebElement sendbutton;
	 @FindBy(xpath="//table[@name='batchtable']")WebElement batchtable;
	 @FindBy(xpath="//td[@name='editicon']")WebElement editicon;
	
	 @FindBy(id="del")WebElement del_manageprogram;
	 List<WebElement> rowsAfter;
	 List<WebElement> rowsBefore;
	 
	 @FindBy(xpath = "//table[@id='data-table']/tbody")WebElement Datatable;
	  public void dashboard(){
	        String dashboardURL = prop.getProperty("DashBoardURl");

	        driver.get("DashBoardURl");
	      
	        String mytitle = driver.getTitle();
	        String title = "DashboardPage";
	        Assert.assertEquals(title, mytitle);

	    }

	public void batchClick()
	{
		batch.click();
	}
	 public void ManageURL(){

	        String BatchURL = driver.getCurrentUrl();
	        Assert.assertEquals("URL should contain Manage ", BatchURL.contains("Manage batch"));
	    }
	 
	 public void verifyHeader(){
	        String headerText = Header.getText();
	        Assert.assertEquals("Header should contain Manage Assignment", headerText.contains("Manage Assignment"));

	    }
	 
	 public void pagination()
	 {
		 Assert.assertEquals("Pagination is displayed", pagination.isDisplayed());
	 }
	 
	 public void verifypageheaders() 
	 {
	        WebElement[] elementstoassert = {checkbox, Batchname,BatchDescription,Batchstatus,Noofclasses, progname,editdel };
	        for(WebElement element: elementstoassert)
	        {
	            String elementname= element.getAttribute("name");
	            Assert.assertEquals("the header" +elementname+ "is displayed", element.isDisplayed());
	        }
}
	 public void deleteIconDisplayed()
	 {
		 String icon=deleteicon.getAttribute("name");
		 Assert.assertEquals("the header" +icon+ "is displayed", deleteicon.isDisplayed());
	 }
	 
	 public void newBatchButton()
	 {
		 String newb=newbatch.getAttribute("name");
		 Assert.assertEquals("the header" +newb+ "is displayed", newbatch.isDisplayed());
	 }
	 
	 public void checkCheckbox()
	 {
		 
		 WebElement table = driver.findElement(By.tagName("tbody"));

	 WebElement allRows = table.findElement(By.tagName("tr"));

	      
	            List<WebElement> cells = allRows.findElements(By.tagName("td"));
	            for(WebElement e1:cells)
	            {
	            	String s=e1.getAttribute("type");
	            	 Assert.assertEquals("the header" +s+ "is displayed", "checkbox");
	            }

	   }
	 
	 public void isEnable()
	 {
		 
		 WebElement table = driver.findElement(By.tagName("tbody"));

	 WebElement allRows = table.findElement(By.tagName("tr"));

	      
	            List<WebElement> cells = allRows.findElements(By.tagName("td"));
	            for(WebElement e1:cells)
	            {
	            	boolean s=e1.isEnabled();
	            	 Assert.assertEquals("the header" +s+ "is enabled", "true");
	            }

	   }
	 
	 public void isEnableDelete()
	 {
		 
		 WebElement table = driver.findElement(By.tagName("tbody"));

	 WebElement allRows = table.findElement(By.tagName("tr"));

	      
	            List<WebElement> cells = allRows.findElements(By.tagName("td"));
	            for(WebElement e1:cells)
	            {
	            	boolean s=e1.isEnabled();
	            	 Assert.assertEquals("the header" +s+ "is enabled", "true");
	            }

	   }
	public void clickDeleteIcon() {
		deleteicon.click();
		
	}
	
	public boolean isAlertPresent()
	
	{
		
		
		try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
		
		
	
	}   // isAlertPresent()
		
	
	public void alertAccept()
	{
	
		driver.switchTo().alert().accept();
	}
	public void pop()
	{
	String Mainwindow = driver.getWindowHandle();
    Set<String> set = driver.getWindowHandles();
    for(String win: set){
    if(!Mainwindow.contentEquals(win)) 
    {
    driver.switchTo().window(win);
    String popupheadingText = popupheading.getText();
    String expectedheading = "Assignment Details";
    Assert.assertEquals(expectedheading, popupheadingText);
        LoggerLoad.info("Popup window is displayed");
    }
    }
	}
	
	public void alertDismiss()
	{
	
		driver.switchTo().alert().dismiss();
	}
	public void checkBatchListed()
	{
	 String mytitle = driver.getTitle();
     String title = "Manage Assignment Page";
     Assert.assertEquals(title, mytitle);
     String tableText = Datatable.getText();
    
	Assert.assertEquals("The selected row is not deleted", tableText.contains(rowText));
	
	
	}
	
	public void clickNewBatch()
	{
		newbatch.click();
	}
	public void batchPopup()
	{
		 String popupwindow= driver.getWindowHandle();
		
	}
	public void popupField()
	{
		WebElement[] arr= {popName,popDes,popProName,popactive,popinactive};
		for(int i=0; i<=arr.length; i++)
		{
			boolean ispresent=arr[i].isDisplayed();
			Assert.assertEquals(ispresent, true);
		}
	}
	
	public void fillFields()
	{
		/*
		 * JsonArray validDataArray = jsondata.getAsJsonArray("Valid Data"); JsonObject
		 * AssigntName = validDataArray.get(0).getAsJsonObject();
		 * popName.sendKeys(BatchData.get("batch Name").getAsString());
		 * popDes.sendKeys(BatchData.get("batch des").getAsString());
		 * popProName.sendKeys(BatchData.get("program name").getAsString());
		 */
		popactive.click();
		sendbutton.click();
		
		
	}
	  public void validatebatchDetails() {
	  }
	  
	  
	  public void errorMessage() {
	        Alert alert = driver.switchTo().alert();
	        String errorMsg = alert.getText();
	        Assert.assertEquals("Error message is displayed", errorMsg.contains("error message"));
	    }
	  
	  public void AllValidData() {
			/*
			 * JsonArray validDataArray = jsondata.getAsJsonArray("Valid Data"); JsonObject
			 * Assigntdetails = validDataArray.get(0).getAsJsonObject();
			 * popName.sendKeys(Assigntdetails.get("Batch Name").getAsString());
			 * popDes.sendKeys(Assigntdetails.get("Batch Description").getAsString());
			 * popProName .sendKeys(Assigntdetails.get("programe name").getAsString());
			 * popactive.click(); sendbutton.click();
			 * 
			 * 
			 */
	         }
	  
	  public void isCheckBoxSelected()
	  {
		 List<WebElement> checkbox= batchtable.findElements(By.className("checkbox"));
		 for(WebElement e:checkbox)
		 {
			 
		
				Assert.assertEquals(false,e.isEnabled() );
				}
		  
	  }
	  public void Deleteicon_manageProgram()
	  {
		 
		
			 
		
				Assert.assertEquals("true",del_manageprogram.isDisplayed() );
				
		  
	  }
	  public void selectCheck()
	  {
		  WebElement checkbox= batchtable.findElement(By.xpath("(//td[@class='class'][1])"));
			WebElement checkbox1= batchtable.findElement(By.xpath("(//td[@class='class'][2])"));
		
		  checkbox.click();
		  checkbox1.click();
	  }
	  
	  
	  public void clickDelete_manageProgram()
	  {
		  del_manageprogram.click();
	  }
	   public void checkCheckboxDeleted()
	   {
		   WebElement checkbox= batchtable.findElement(By.xpath("(//td[@class='class'][1])"));
			  Assert.assertEquals("flase",checkbox.isDisplayed());
	   }
	  
	  
	   public void checkenable()
	   {
		   WebElement checkbox= batchtable.findElement(By.xpath("(//td[@class='class'][1])"));
			WebElement checkbox1= batchtable.findElement(By.xpath("(//td[@class='class'][2])"));
			  Assert.assertEquals("true",checkbox.isSelected());
			  Assert.assertEquals("true",checkbox1.isSelected());
	   }
	   public void editEnable()
	   {
		   Assert.assertEquals("true", editicon.isEnabled());
	   }
	   public void selectEditIcon()
	   {
		   editicon.click();
	   }
	   
	   public void eraseDatafields()
	   {
		   popName.clear();
	   }
	  
	  
	  
	
}