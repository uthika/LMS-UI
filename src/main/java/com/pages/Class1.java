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
import com.qa.util.LoggerLoad;

public class Class1 
{
	    WebDriver driver;
	    ConfigReader CR = new ConfigReader();
	    Properties prop = CR.init_prop();
	    long endtime, starttime;
	    public Class1() 
	    {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(driver, this);
	    }
	    
	  
	 @FindBy(xpath = "//button[text()='Class']") WebElement newClassButton;
	 @FindBy(xpath = "//header[@id='headerid']") WebElement Header;
	 @FindBy(xpath = "//html/body/") WebElement body;
	 @FindBy(css = ".button") WebElement deleteIcon;
	 @FindBy(id = "@searchbox") WebElement searchbox;
	 @FindBy(xpath = "//button[text()='addClass']") WebElement addClassButton;
	 @FindBy(id="Checkbox") WebElement HeaderCheckbox;
	 @FindBy(id="BatchId") WebElement HeaderBatchId;
	 @FindBy(id="ClassNo") WebElement HeaderClassNo;
	 @FindBy(id="ClassDate") WebElement HeaderClassDate;
	 @FindBy(id="ClassTopic") WebElement HeaderClassTopic;
	 @FindBy(id="StaffId ") WebElement HeaderStaffId;
	 @FindBy(id="Description") WebElement HeaderDescription;
	 @FindBy(id="Recording ") WebElement HeaderRecording;
	 @FindBy(id="Edit") WebElement HeaderEdit;
	 @FindBy(id="Delete") WebElement HeaderDelete;
	 
	 @FindBy(xpath="//button[text()='EditClass']") WebElement editClassButton;
	
	 @FindBy(xpath="//button[text()='DeleteClass']") WebElement deleteClassButton;
	 @FindBy(xpath="//button[text()='SortIcon']") WebElement sortButton;
	 @FindBy(xpath = "//button[@id='checkbox']") WebElement checkbox;
	 
	 @FindBy(xpath="//button[text()='p-paginator-prevpages']") WebElement prevpages;
	 @FindBy(xpath="//button[text()='p-paginator-firstpage']") WebElement firstpage;
	 @FindBy(xpath="//button[text()='p-paginator-nextpage']") WebElement nextpage;
	 @FindBy(xpath="//button[text()='p-paginator-lastpages']") WebElement lastpages;
	 
	 @FindBy(xpath="//button='footertext']") WebElement footerText;
	 @FindBy(xpath="//'textBox']") WebElement srchTextBox;
	 @FindBy(xpath="//'button']") WebElement SearchIcon;
	 @FindBy(xpath="//'datatable']") WebElement Dt;
	 List<WebElement> rows = driver.findElements(By.xpath("//'datatable']"));
	 List<WebElement> columnheaders = driver.findElements(By.xpath("//[@id='data-table"));
	   public Class1(WebDriver driver){
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(driver, this);
	    }
	 
	        public void dashboard()
	        {
	       
			long starttime = System.currentTimeMillis();
	        String mytitle = driver.getTitle();
	        String title = "DashboardPage";
	        Assert.assertEquals(title, mytitle);
	       
	    }
	 
	        public void clickClassButton()
	        {
	        newClassButton.click();
	        long endtime = System.currentTimeMillis();
	        String Classpage = driver.getTitle();
	        String Title = "Manage Class Page";
	        Assert.assertEquals(Title, Classpage );
	    }
	        
	         public void manageURL()
	         {
	         String ClassURL = driver.getCurrentUrl();
	         Assert.assertTrue("URL should contain Manage Class ", ClassURL.contains("Manage Class"));
	    }
	        
	        public void responseTime() 
	        { 	
	        	 long responsetime = endtime - starttime;
	             System.out.println("Response time: "+responsetime + "milliseconds");
	             LoggerLoad.info("The response time is " +responsetime );
	    }
	        
             public void pageHeader()
             {
             String classHeader = Header.getText();
             String ClassHeader = "Manage Class";
             Assert.assertEquals(ClassHeader,classHeader);	
	     }
             
             public void buttonSpell() 
             {
            	 newClassButton.click();
             }
             
             public void correctSpell() 
             {
             List<WebElement> bodytext = driver.findElements(By.className(""));
             for (WebElement bodytxt: bodytext) {
            	 String bodyvalue = bodytxt.getAttribute("val");
            	 System.out.println("Check spell " + bodyvalue); 
             }
        
	    }
             
             public void disabledIcon() 
             {   
            	 boolean deleteIconDisabled = deleteIcon.isEnabled();
            	 if (deleteIconDisabled)
                 Assert.assertFalse(deleteIconDisabled);
             }

             public void searchBox()
             { 
            	 Assert.assertTrue(searchbox.isDisplayed());
            	 
             }

             public void addNewClassButton()
             {
            	 Assert.assertFalse("Button is displayed  ", addClassButton.isDisplayed());
            	
            	 
             }
             
             public void columnHeader(String header)
             {
            	
              switch(header) {
              case "Check box symbol":
            	  HeaderCheckbox.isDisplayed();
            	  break;
            	  
              case "Batch Id":
            	  HeaderBatchId.isDisplayed();
            	  break;
            	  
              case "Class No":
            	  HeaderClassNo.isDisplayed();
            	  break;
            	  
              case "Class Date":
            	  HeaderClassDate.isDisplayed();
            	  break;
            	  
              case "Class Topic":
            	  HeaderClassTopic.isDisplayed();
            	  break;
            	  
              case "Staff Id":
            	  HeaderStaffId.isDisplayed();
            	  
            	  break;
            	  
              case "Description":
            	  HeaderDescription.isDisplayed();
            	  break;
            	  
              case "Comments":
            	  HeaderRecording.isDisplayed();
            	  break;
            	  
              case "Edit":
            	  HeaderEdit.isDisplayed();
            	  break;
            	  
              case "Delete":
            	  HeaderDelete.isDisplayed();
            	  break;
             }
              
             }
             
             public void editClassButton()
             {
              
			for (WebElement row : rows) 
              {
              WebElement cellvalue = row.findElement(By.xpath("//celldata]"));
              String celltext = cellvalue.getText();
               if (!celltext.isEmpty())
               {
               WebElement editIcon = row.findElement(By.xpath("//editbutton]"));
               Assert.assertTrue("Edit button is displayed ",editIcon.isDisplayed());
               }
              }
             }
             
             public void editclassButton()
             {
              
			 for (WebElement row : rows)
			 {
               WebElement cellval = row.findElement(By.xpath("//celldata"));
               String celltext = cellval.getText();
               if (celltext.isEmpty()) 
               {
               WebElement editIcon = row.findElement(By.xpath("//editbutton]"));
              Assert.assertFalse("Edit button is not displayed ",editIcon.isEnabled());
               }     
             }
             }
             
             public void deleteClassButton()
             {
            
		     for (WebElement row : rows)
		     {
             WebElement cellval1 = row.findElement(By.xpath("//deletecell']"));
             String celltext = cellval1.getText();
              if (!celltext.isEmpty()) 
              {
            WebElement deleteIcon = row.findElement(By.xpath("//deletebutton']"));
            Assert.assertTrue("Edit icon is displayed ",deleteIcon.isDisplayed());
            	        }
            	    }
             }
             
             public void deleteclassButton()
             {
         
      		   for (WebElement row : rows) 
      		   {
                 WebElement cellval = row.findElement(By.xpath("//deletecell']"));
                 String celltext = cellval.getText();
                  if (!celltext.isEmpty()) 
                  {
                  WebElement deleteIcon = row.findElement(By.xpath("//deletebutton']"));
                  Assert.assertFalse("Edit icon is displayed ",deleteIcon.isDisplayed());
                  }
                  }
                } 
             
             public void sortIcon()
             {
            	 for (WebElement columnheader : columnheaders) {
            	        String columnText = columnheader.getText();
            	        if (!columnText.contains("Edit") && !columnText.contains("Delete")) {
            	            WebElement sortIcon = columnheader.findElement(By.xpath("//span[@class='sort-icon']"));
            	            Assert.assertTrue("Sort icon is displayed", sortIcon.isDisplayed());
            	        } else {
            	            LoggerLoad.info("The Sort icon is not displayed");
            	        }
            	    }
            	 
             }
             public void checkBox()
             {
            	 for (WebElement row: rows)
            	 {
            	        WebElement cellval = row.findElement(By.xpath("//td[@class='entry-cell']"));
            	        String cellText = cellval.getText();
            	        if(!cellText.isEmpty())
            	        {
            	            WebElement checkbox = row.findElement(By.xpath("//button[@id='checkbox']"));
            	            Assert.assertTrue("Checkbox is displayed", checkbox.isDisplayed());
            	        }
            	    }
            	 
             }
           
             public void paginationcontrol()
             {
            	 Assert.assertTrue(prevpages.isDisplayed());
            	 Assert.assertTrue(nextpage.isDisplayed());
            	 Assert.assertTrue(firstpage.isDisplayed());
            	 Assert.assertTrue(lastpages.isDisplayed());
             } 
             
             public void footer()
             {
            	String num = footerText.getText();
            	System.out.println("Number of classes" + num);
            	 
             }
             
             public String batchIdSearch()
             {
             String batch= "Java1batch";
         	 srchTextBox.sendKeys(batch);
 			
 			List<WebElement> batch_size = driver.findElements(By.xpath("span_textBox"));
				
			for(int i = 0; i<batch_size.size();i++) {
				String temp = batch_size.get(i).getText();
 
				if ((temp.toLowerCase().contains(batch.toLowerCase()))){
					Assert.assertEquals(true, batch +" is displayed on " + temp);
				}else {
					Assert.assertEquals(false, batch + " is not displayed " + temp);
		
				}
 			return temp;
         	}
			return batch;
             
             
             }    
             public void batchIddisplay()
             
             {
            	 String Text = Dt.getText();
                 Assert.assertFalse("Batchid is displayed ", Text.isEmpty());
             }
             
             public void Invalidbatchid()
             {
            	     srchTextBox.click();
            	     srchTextBox.sendKeys("Invalid batch id");
            	     SearchIcon.click();
             }
             
             public void emptyData()
             {
                 String Text = Dt.getText();
                 Assert.assertTrue("Nothing exists ", Text.isEmpty());
             }
             
             public void clasNo(){
            	 srchTextBox.click();
        	     srchTextBox.sendKeys("Class No");
                 SearchIcon.click();
             }
             public void ValidateclasNo(){
             Assert.assertTrue("Entries with class no is displayed ", HeaderClassNo.isDisplayed());
             }
             
             public void NoclasNo(){
            	 
            	 srchTextBox.click();
        	     srchTextBox.sendKeys("Class No does not exist");
                 SearchIcon.click();
             }
             
             public void clasTopic()
             {
            	 srchTextBox.click();
        	     srchTextBox.sendKeys("Class Topic");
                 SearchIcon.click();
             }
             
             public void  displayclasTopic()
             {
                 Assert.assertTrue("class topic is displayed ", HeaderClassTopic.isDisplayed());
             }
             
             public void NonclasTopic(){
            	 srchTextBox.click();
        	     srchTextBox.sendKeys("Class Topic does not exist");
                 SearchIcon.click();
             }
             
             public void stafId()
             {
            	 srchTextBox.click();
        	     srchTextBox.sendKeys("Staff Id");
                 SearchIcon.click(); 
             }
             
             public void  displaystafId()
             {
                 Assert.assertTrue("Staff Id is displayed ", HeaderClassTopic.isDisplayed());
             }
             
             public void NonstaffId()
             {
            	 srchTextBox.click();
        	     srchTextBox.sendKeys("Staff id does not exist");
                 SearchIcon.click();
             }
}



