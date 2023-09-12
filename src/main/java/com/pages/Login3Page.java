package com.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;

public class Login3Page {
	private WebDriver driver;
	Actions actions = new Actions(driver);
	
	// 1. By Locators: Object Repository
	@FindBy (xpath = "//input[@type = 'text']") WebElement email;
	@FindBy (xpath ="//button[text()='Send Link']") WebElement sendLinkBtn;
	@FindBy (xpath= "//a[@href='/register']") WebElement forgotunpwdlink;
	@FindBy (xpath = "//input[@type = 'symbol']") WebElement emailSblelem;
	
	// 2. Constructor of the page class:
		public Login3Page(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		public WebDriver getDriver() {
	        return driver;
	    }
			
	 public void clickForgotLink() {
		forgotunpwdlink.click();
	 }
	 public String verifyPageTitle() {
			return driver.getTitle();
		}

	public String verifyForgotPage() {
		return driver.getTitle();
	}
	public String getEmailTextColor() {
        return email.getCssValue("color");
 }
	public String getTextFieldText() {
        return email.getAttribute("value");
    }
	 public boolean isSendLinkDisplayed() {
	        return sendLinkBtn.isDisplayed();
	        
	    }
	 public void clickSendLink() {
			sendLinkBtn.click();
		 }
	 public void verifyEmailSymbolIsDisplayed() {
	        
	        // Check if the * symbol element is displayed
	        if (emailSblelem.isDisplayed()) {
	            System.out.println("The * symbol next to user text is displayed.");
	        } else {
	            System.out.println("The * symbol next to user text is not displayed.");
	            
	        }
	    }
	 public WebElement getYourInputField() {
	        return email;
	    }
	 
	 public void enterValidEmail(String emailid) {
	    	email.sendKeys(emailid);
      }
	 public boolean hasResetLinkEmailArrived() {
	        
	        return true; 
	    }
	 public void enterInvalidEmail(String emailid) {
	    	email.sendKeys(emailid);
   }
	 public boolean resetLinknotreceived() {
	        
	        return true; 
	    }		

			
			
			
			

}
