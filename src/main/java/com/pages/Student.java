package com.pages;

import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.util.ConfigReader;
import com.qa.util.LoggerLoad;

public class Student {

	WebDriver driver;
	ConfigReader CR = new ConfigReader();
	Properties prop = CR.init_prop();
	long endtime, starttime;
	String s;

	@FindBy(xpath = "//a[text()='student']")
	WebElement student;
	@FindBy(xpath = "//a[text()='navigation']")
	WebElement navigatetitle;
	@FindBy(xpath = "//title='navigation']")
	WebElement title;
	@FindBy(xpath = "//select='dropdown']")
	WebElement dropdown;
	@FindBy(xpath = "//select='dropdown']")
	WebElement dropdown1;
	

	public void dashboard() {
		String dashboardURL = prop.getProperty("DashBoardURl");

		driver.get("DashBoardURl");

		String mytitle = driver.getTitle();
		String title = "DashboardPage";
		Assert.assertEquals(title, mytitle);

	}
	


	public void studentClick() {
		student.click();
	}

	public void checkTitle() {
		String title = driver.getTitle();
		Assert.assertEquals("Student Details", title.contains("Student Details"));
	}

	public void validateResponseTime() {
		long responsetime = endtime - starttime;
		System.out.println("Response time: " + responsetime + "milliseconds");
		LoggerLoad.info("The response time is " + responsetime);

	}

	public void navigationTitle() {

		String text = navigatetitle.getText();

		Assert.assertEquals("Learning management systems", text);

	}

	public void alignment() {
		String iscenter = title.getCssValue("center");
		Assert.assertEquals("center", iscenter);
	}

	public void isDropdownPresent() {
		boolean match = dropdown.isDisplayed();

		Assert.assertEquals("true", match);
	}

	

	public void isDropdownContainsSearch() {
		WebElement searchtext = dropdown.findElement(By.id("SearchText"));  
		boolean issearchPresent=searchtext.isDisplayed();
		Assert.assertEquals("true", issearchPresent);
		
	}
	
	public void spellCheckinDropdown()
	{
		String spellCheck=dropdown.getText();
		Assert.assertEquals("Select Student Name",spellCheck);
		
	}
	public void spellCheckinDropdown2()
	{
		String spellCheck1=dropdown1.getText();
		Assert.assertEquals("Select batch Id",spellCheck1);
	}
	
	public void ddcontainInt()
	{
		Select s=new Select(dropdown1);
		List<WebElement> options=dropdown1.findElements(By.xpath("//options[@id='option']"));
		boolean allOptionsContainOnlyNumbers = true;
		 Pattern pattern = Pattern.compile("\\d+");

		for(WebElement we:options)
		{
			String integer=we.getText();
			  if (!pattern.matcher(integer).matches()) {
	                allOptionsContainOnlyNumbers = false;
	                break; // Exit the loop if any option doesn't contain only numbers
	            }

			 Assert.assertEquals("false",allOptionsContainOnlyNumbers);
		}
		 
	}
	
	public void scrollDropdown()
	{
	
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdown).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
	}
	public void scrollDropdown1()
	{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdown1).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
	}
	public void dropdowncheck()
	{
	String name="Select Student Name";
	String id="Select batch id";
		List<WebElement> l=driver.findElements(By.tagName("select"));
		for(WebElement e:l)
		{
			
			if(e.findElement(By.xpath("(//select[@classname='dropdown'])[1]")).getText().equals(name))
			{
			
			 Assert.assertEquals("Select student Name",name);
		}
		else if(e.findElement(By.xpath("(//select[@classname='dropdown'])[2]")).getText().equals(id))
		{
			
			 Assert.assertEquals("Select batch id",id);
		}
			
		}
	}
	
	public void greycolour()
	{
		

        // Use JavaScript to change the text color to gray
        String script = "arguments[0].style.color='gray';";
        ((JavascriptExecutor) driver).executeScript(script,dropdown);
	}
	public void greycolour2()
	{
		

        // Use JavaScript to change the text color to gray
        String script = "arguments[0].style.color='gray';";
        ((JavascriptExecutor) driver).executeScript(script,dropdown1);
	}
	public void geturl()
	{
		driver.get("student url");
	}
	public void selectStudent()
	{
		Select s=new Select(dropdown);
		s.selectByIndex(0);
		
	}
	public void notfoundtext()
	{
		String s=dropdown.getText();
		Assert.assertNotEquals(" ",s);
	}
	
	public void selectbatchid()
	{
		Select s=new Select(dropdown1);
		s.selectByIndex(0);
		
	}
	public void notfoundtext1()
	{
		String s=dropdown1.getText();
		Assert.assertNotEquals(" ",s);
	}
	public void enterOnddtext()
	{
		dropdown.findElement(By.className("textbox")).sendKeys("x");
	}
	public void enterOnddtext2()
	{
		dropdown1.findElement(By.className("textbox")).sendKeys("128");
	}
	public void isstudendetailDisplayed()
	{
	boolean x=	dropdown1.findElement(By.className("textbox")).isDisplayed();
		Assert.assertEquals(x, "true");
	}
	
	public boolean particularStudent()
	{
		List<WebElement> options= dropdown.findElements(By.xpath("//option[@classname='option']"));
		for(WebElement e:options)
		{
			if (e.equals("Rama"))
			{
				return true;
			}
			else 
				return false;
		}
		Assert.assertTrue(true);
	
	}
		
	}
	
	
	
	
	
	
	
	
	
	
}
