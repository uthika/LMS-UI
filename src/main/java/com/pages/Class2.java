package com.pages;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;


public class Class2 {
	   

		WebDriver driver;
	    ConfigReader CR = new ConfigReader();
	    Properties prop = CR.init_prop();
	    
	    public Class2() 
	    {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(driver, this);
	    }
	
	     @FindBy(xpath = "//button[addNewClass()='addNewclass']") WebElement addnewClassButton;
		 @FindBy(id="BatchIdtextbox") WebElement fieldBatchId;
		 @FindBy(id="ClassNotextbox") WebElement fieldClassNo;
		 @FindBy(id="ClassDatetextbox") WebElement fieldClassDate;
		 @FindBy(id="ClassTopictextbox") WebElement fieldClassTopic;
		 @FindBy(id="StaffIdtextbox") WebElement fieldStaffId;
		 @FindBy(id="Descriptiontextbox") WebElement fieldDescription;
		 @FindBy(id="Recordingtextbox") WebElement fieldRecording;
		 @FindBy(id="Commentstextbox") WebElement fieldComments;
		 @FindBy(id="Notestextbox") WebElement fieldNotes;
		 
		 @FindBy(xpath="//select[@name='Batch']") WebElement ddBatch;
		 @FindBy(xpath="//select[@name='Staff']") WebElement ddStaff;
		 @FindBy(xpath ="//[@class='calendarContainer']") WebElement ccCalender;
		 @FindBy(id="[Button'saveclass']") WebElement saveclass;
		 @FindBy(id="[Button'deleteclass']") WebElement deleteclass;
		 @FindBy(id="[Button'scancelclass']") WebElement cancelclass;
	    
		 public void addNewclass() {
		 addnewClassButton.click();
		 String addClassespage = driver.getTitle();
	     String Title = "Add Classes Page";
	     Assert.assertEquals(Title,addClassespage);
		 
	}
	     public void classDetailsheader() {
	    	 String Classdetails = driver.getTitle();
	    	 String classDetails = "Class Details";
	    	 Assert.assertEquals(classDetails, Classdetails);
	    	 
	     }
	     
	     public void classDetailsField(String field)
         {
        	
          switch(field) {
        	  
          case "Batch ID":
        	  fieldBatchId.isDisplayed();
        	  break;
        	  
          case "No of Classes":
        	  fieldClassNo.isDisplayed();
        	  break;
        	  
          case "Class Topic":
        	  fieldClassTopic.isDisplayed();
        	  break;
        	  
          case "Class Date":
        	  fieldClassDate.isDisplayed();
        	  break;
        	  
          case "Staff Id":
        	  fieldStaffId.isDisplayed();
        	  break;
        	  
          case "description":
        	  fieldDescription.isDisplayed();
        	  break;
        	  
          case "Recordings":
        	  fieldRecording.isDisplayed();
        	  break;
        	  
          case "Comments":
        	  fieldComments.isDisplayed();
        	  break;
        	  
          case "Notes":
        	  fieldNotes.isDisplayed();
        	  break;
         }
         }
	     
	     public void textBoxSize() {
	    	 
	    	 List<WebElement> textboxes = driver.findElements(By.xpath("//['InputInner']"));

	    	 System.out.println(textboxes.size());

	    	 for(int i=1; i<=textboxes.size(); i=i+1);
	    	 {
	    	     System.out.println(textboxes.size());
	    	 }
	    	 
	     }
	     
	     public void ddBatchId() {
	    	 if(ddBatch.isDisplayed())
	    	 {
	    		 System.out.println("Dropdown for batchid present");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Dropdown for batchid not present"); 
	    	 }
	     }
	     
	     public void ddStaffId() {
	    	 if(ddStaff.isDisplayed())
	    	 {
	    		 System.out.println("Dropdown for batchid present");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Dropdown for batchid not present"); 
	    	 }
	     }
	     
	     public void cCalender() {
	    	 Assert.assertTrue(ccCalender.isEnabled());
	     }
	     
	     public void saveClass(){
	    	 Assert.assertTrue(saveclass.isEnabled());
	     }
	     
         public void deleteClass(){
        	 Assert.assertTrue(deleteclass.isEnabled());
	     }
         
         public void cancelClass(){
        	 Assert.assertTrue(cancelclass.isEnabled());
	     }
}
