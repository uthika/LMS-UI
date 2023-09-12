package com.pages;


import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.util.ConfigReader;

public class Dashboard1  {
	
	 WebDriver driver;
	    ConfigReader CR = new ConfigReader();
	    Properties prop = CR.init_prop();
	    

	
		
		  public Dashboard1(WebDriver driver) { PageFactory.initElements(driver, this);
		  }
		  @FindBy(xpath = "//button[text()='Login']") WebElement Loginbutton;
		  @FindBy(xpath="//h2[text()='Manage_Program'")WebElement dashboardtitle ;
		  @FindBy(xpath="//lintText[text()='student'")WebElement student;
		  @FindBy(xpath="//lintText[text()='program'")WebElement program;
		  @FindBy(xpath="//lintText[text()='batch'")WebElement batch;
		  @FindBy(xpath="//lintText[text()='class'")WebElement classlink;
		  @FindBy(xpath="//lintText[text()='user'")WebElement user;
		  @FindBy(xpath="//lintText[text()='LMS'")WebElement lms;
		  @FindBy(xpath="(//a[@class='naviagations'])[1]")WebElement StudentPosition;
		  @FindBy(tagName="a")WebElement position;
		  
		  
		  
		  
		  public void Loginbutton(){
		        String Loginurl = prop.getProperty("Login");

		        Loginbutton.click();
		        long starttime = System.currentTimeMillis();
		        String mytitle = driver.getTitle();
		        String title = "Login";
		        Assert.assertEquals(title, mytitle);
		  }
		 
		  
		  public void Login(){
		        String Loginurl = prop.getProperty("Login");

		       
		        driver.get("Login");
		        long starttime = System.currentTimeMillis();
		        String mytitle = driver.getTitle();
		        String title = "Login";
		        Assert.assertEquals(title, mytitle);
		  }
		  
		  
		  public void validateDashboardTitle(){
			  
			 String dashboardtitle= driver.getTitle();
			  Assert.assertEquals("Manage Program", dashboardtitle);
		        
		    }
		 
		  public void validateTitlePosition(){
			  
		String leftalign=dashboardtitle.getCssValue("left");
			  
		  Assert.assertEquals("left", leftalign);
			 
			    }
		  
		  public void validateNavigationbar(){
			  
				String rightalign=dashboardtitle.getCssValue("right");
					  
				  Assert.assertEquals("right", rightalign);
					 
					    }
		  
		  public void validateText()
		  {
			  String stu=student.getText();
			 String prog= program.getText();
			 String bat= batch.getText();
			  Assert.assertEquals("Student", stu);
			  Assert.assertEquals("Program", prog);
			  Assert.assertEquals("Batch", bat);
			  
		  }
		  public void lmsTitle()
		  {
			  String lmstitle= lms.getText();
			  Assert.assertEquals("Learning Management System", lmstitle);
			  
		  }
		  
		  public void positionOfStudent()
		  {
			  
			WebElement position1=  position.findElement(By.xpath("//a[1]"));
			String firststposition=  position1.getText();
			  
				  Assert.assertEquals("Student",firststposition );
		  }
		  public void positionOfProgram()
		  {
			  
			WebElement position2=  position.findElement(By.xpath("//a[2]"));
			String secondposition=  position2.getText();
			  
				  Assert.assertEquals("Student",secondposition );
		  }
		  
		  public void positionOfBatch()
		  {
			  
			WebElement position3=  position.findElement(By.xpath("//a[3]"));
			String thirdposition=  position3.getText();
			  
				  Assert.assertEquals("Student",thirdposition );
		  }
		  
		  public void positionOfClass()
		  {
			  
			WebElement position4=  position.findElement(By.xpath("//a[4]"));
			String forthposition=  position4.getText();
			  
				  Assert.assertEquals("Student",forthposition );
		  }
		  
		  
		  public void positionOfUser()
		  {
			  
			WebElement position5=  position.findElement(By.xpath("//a[5]"));
			String fifthposition=  position5.getText();
			  
				  Assert.assertEquals("Student",fifthposition );
		  }
		  
		  public void positionOfAssignment()
		  {
			  
			WebElement position6=  position.findElement(By.xpath("//a[6]"));
			String sixthposition=  position6.getText();
			  
				  Assert.assertEquals("Student",sixthposition );
		  }
		  
		  public void positionOfAttendance()
		  {
			  
			WebElement position7=  position.findElement(By.xpath("//a[7]"));
			String sevenposition=  position7.getText();
			  
				  Assert.assertEquals("Student",sevenposition );
		  }
		  public void positionOfLogout()
		  {
			  
			WebElement position8=  position.findElement(By.xpath("//a[8]"));
			String eigthposition=  position8.getText();
			  
				  Assert.assertEquals("Student",eigthposition );
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
}
