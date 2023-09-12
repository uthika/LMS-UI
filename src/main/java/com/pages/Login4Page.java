package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login4Page {

	private WebDriver driver;
	
	@FindBy (xpath = "//input[@type = 'retype-password']") WebElement retypepwd;
	@FindBy (xpath = "//input[@type = 'password']") WebElement newpwd;
	@FindBy (xpath ="//button[text()='Send Link']") WebElement submitBtn;
	@FindBy(id = "headerElementId") WebElement headerElement;
	@FindBy (xpath ="//button[text()='Send Link']") WebElement submitBtnText;
	@FindBy (xpath = "//input[@type = 'retype-password']") WebElement retypepwdText;
	@FindBy (xpath = "//input[@type = 'password']") WebElement pwdText;
	@FindBy (xpath= "//a[@href='/reset-password']") WebElement resetpwd;
	@FindBy (xpath ="//button[text()='Confirmation message']") WebElement pwdResetsuccessMsg;
	@FindBy (xpath="//div[@class='alert alert-primary']" ) WebElement errorMsg;
	
//	2. Constructor of the page class:
		public Login4Page(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		public WebDriver getDriver() {
	        return driver;
	    }
		public void clickSubmitBtn() {
			submitBtn.click();
		 }
		 public String verifyPageTitle() {
				return driver.getTitle();
			}
		 public String submittext() {
			    return submitBtn.getText();
			}

		    		    
		    public boolean areSpellingsCorrectInAllFields() {
		        boolean isSpellingCorrect = true;

		        // Get the text from header, submit button, and text boxes
		        String headerText = headerElement.getText();
		        String submitButtonText = submitBtnText.getText();
		        String firstTextBoxPlaceholder = pwdText.getAttribute("placeholder");
		        String secondTextBoxPlaceholder = retypepwdText.getAttribute("placeholder");

		        // Check if the text matches the expected spellings
		        if (!headerText.equals("Reset Password") ||
		            !submitButtonText.equals("Submit") ||
		            !firstTextBoxPlaceholder.equals("Type in new Password") ||
		            !secondTextBoxPlaceholder.equals("ReType Password")) {
		            isSpellingCorrect = false;
		        }

		        return isSpellingCorrect;
		    }

		    public boolean issubmitBtnDisplayed() {
		        return submitBtn.isDisplayed();
		        
		    }
		    public boolean areTextFieldsVisible() {	           
		        return newpwd.isDisplayed() && retypepwd.isDisplayed();
		    }
		    public WebElement getYourInputField() {
		        return submitBtn;
		    }
		    public String getNewPwdText() {
		        return pwdText.getText();
		    }
		    public String getRetypePwdText() {
		        return retypepwdText.getText();
		    }
		    public boolean isTextBoxDisabled() {
		        return !newpwd.isEnabled();
		    }
		    public void clickTypeInNewPasswordField() {
		        newpwd.click();
		    }
		    public boolean isTypeInNewPasswordTextBoxEnabled() {
		        return newpwd.isEnabled();
		    }
		    public boolean isRetypePasswordTextBoxEnabled() {
		        return retypepwd.isEnabled();
	   
		}
		    public void clickRetypePasswordField() {
		        retypepwd.click();
		    }
		    public void enterSamePasswordInFieldsAndSubmit() {
		        String password = "n!nja$secur3"; 
		        newpwd.sendKeys(password);
		        retypepwd.sendKeys(password);
		        submitBtn.click();
		    }
		    public String getResetPasswordConfirmationMessage() {
		        return pwdResetsuccessMsg.getText();
		    }
			
		    public void enterInvalidPasswordInFieldsAndSubmit() {
		        String password = "admin"; 
		        newpwd.sendKeys(password);
		        retypepwd.sendKeys(password);
		        submitBtn.click();
		    }
		    public String getErrorMessage() {
		        return errorMsg.getText();
		    }
		    public void enterMismatchpwdAndClickSubmit() {
		        	        
		        newpwd.sendKeys("password123"); 
		        retypepwd.sendKeys("123password"); 

		        submitBtn.click();
		    }

}
