package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.testng.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.qa.util.ConfigReader;
import com.qa.util.JSONReader;
import com.qa.util.LoggerLoad;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login2Page {
	private WebDriver driver;
	Actions actions = new Actions(driver);
	ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
	JSONReader jsonreader = new JSONReader();
    String filepath = prop.getProperty("TestdataPath");
    JsonObject jsondata = jsonreader.readJsonData(filepath);
    

	private String linkURL;
	private int expectedResponseCode;
	
	// 1. By Locators: Object Repository
 
	@FindBy (xpath ="//button[text()='Login']") WebElement LoginBtn;
	@FindBy (xpath= "//a[@href='/register']") WebElement forgotunpwdlink;
	@FindBy (xpath= "//a[@href='/reset-password']") WebElement resetpwd;
	@FindBy (xpath = "//input[@type = 'text']") WebElement uname;
	@FindBy (xpath = "//input[@type = 'password']") WebElement pwd;
	@FindBy(xpath = "//header[@id='header-id']") WebElement header;
	@FindBy (xpath = "//input[@type = 'symbol']") WebElement userSblelem;
	@FindBy (xpath = "//input[@type = 'symbol']") WebElement pwdSblelem;
	@FindBy (xpath ="//button[text()='Login']") WebElement LogoutBtn;
	@FindBy (xpath="//div[@class='alert alert-primary']" ) WebElement errorMsg;
	// 2. Constructor of the page class:
	public Login2Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	public boolean verifyLoginPage() {
		return forgotunpwdlink.isDisplayed();
	}
	
	public boolean isLinkBroken(String url, int expectedResponseCode) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            int actualResponseCode = response.getStatusLine().getStatusCode();
            return actualResponseCode >= expectedResponseCode;
        } catch (Exception e) {
            // Handle exceptions (e.g., connection errors)
            return true; // Consider it a broken link if there's an exception
        }
    }
	 public String getHeaderText() {
	         return header.getText();
	    }
	 public boolean areTextFieldsVisible() {	           
	        return uname.isDisplayed() && pwd.isDisplayed();
	    }
	 public String getFirstTextFieldText() {
	        return uname.getAttribute("value");
	    }
	 public void verifyUserSymbolIsDisplayed() {
	        
	        // Check if the * symbol element is displayed
	        if (userSblelem.isDisplayed()) {
	            System.out.println("The * symbol next to user text is displayed.");
	        } else {
	            System.out.println("The * symbol next to user text is not displayed.");
	            
	        }
	    }
	 public String getsecondTextFieldText() {
	        return pwd.getAttribute("value");
	    }
	 public void verifyPwdSymbolIsDisplayed() {
	        
	        // Check if the * symbol element is displayed
	        if (pwdSblelem.isDisplayed()) {
	            System.out.println("The * symbol next to user text is displayed.");
	        } else {
	            System.out.println("The * symbol next to user text is not displayed.");
	            
	        }
	    }
	 public WebElement getYourInputField() {
	        return uname;
	    }
	 public WebDriver getDriver() {
	        return driver;
	    }
	 public boolean isLoginButtonVisible() {
	        try {
	            
	            return LoginBtn.isDisplayed();
	        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            return false;
	        }
	    }
	 public boolean isLoginButtonCentered() {
	        try {
	            int buttonCenterX = LoginBtn.getLocation().getX() + (LoginBtn.getSize().getWidth() / 2);
	            int windowCenterX = driver.manage().window().getSize().getWidth() / 2;
	            int tolerance = 10; // You can adjust this value based on your requirements
	            return Math.abs(buttonCenterX - windowCenterX) <= tolerance;
	        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            return false;
	        }
	    }
	 public boolean isForgotLinkDisplayed() {
	        return forgotunpwdlink.isDisplayed();
	        
	    }
	 
	 public boolean resetPwdLinkDisplayed() {
	        return resetpwd.isDisplayed();
	        
	    }
	 public String getUserTextColor() {
	        return uname.getCssValue("color");
	 }
	 public String getPwdTextColor() {
	        return pwd.getCssValue("color");
	 }
	 
	 public void verifyInputFieldCentered() {
		 WebElement inputField = getYourInputField();
		 	 // Get the location and size of the input field
	        Point inputFieldLocation = inputField.getLocation();
	        Dimension inputFieldSize = inputField.getSize();

	        // Get the browser window size
	        Dimension windowSize = getDriver().manage().window().getSize();

	        // Calculate the center coordinates of the window
	        int windowCenterX = windowSize.getWidth() / 2;
	        int windowCenterY = windowSize.getHeight() / 2;

	        // Calculate the expected position of the input field's center
	        int expectedInputFieldCenterX = inputFieldLocation.getX() + (inputFieldSize.getWidth() / 2);
	        int expectedInputFieldCenterY = inputFieldLocation.getY() + (inputFieldSize.getHeight() / 2);

	        // Calculate a tolerance value to account for potential misalignments
	        int tolerance = 5; // You can adjust this value based on your requirements

	        // Assert that the input field is close to the center of the page
	        Assert.assertTrue(Math.abs(expectedInputFieldCenterX - windowCenterX) <= tolerance);
	        Assert.assertTrue(Math.abs(expectedInputFieldCenterY - windowCenterY) <= tolerance);
			 
	 }
	 public void loginWithValidCredentials() {
	 JsonArray validLoginDataArray = jsondata.getAsJsonArray("Valid Login Data");
	 JsonObject userData = validLoginDataArray.get(0).getAsJsonObject();
	 String username = userData.get("User").getAsString();
	 String password = userData.get("Password").getAsString();
	 }
	
	 public void enterUsername() {
		 JsonArray UserDataArray = jsondata.getAsJsonArray("User Data");
		 JsonObject userData = UserDataArray.get(0).getAsJsonObject();
		 String username = userData.get("User").getAsString();
		 	       
	    }
	 public void loginWithInvalidCredentials() {
		 JsonArray invalidLoginDataArray = jsondata.getAsJsonArray("Invalid Login Data");
		 JsonObject userData = invalidLoginDataArray.get(0).getAsJsonObject();
		 String username = userData.get("User").getAsString();
		 String password = userData.get("Password").getAsString();
		 }
	 
	    
	 public void enterpassword() {
		 JsonArray PasswordDataArray = jsondata.getAsJsonArray("User Data");
		 JsonObject userData = PasswordDataArray.get(0).getAsJsonObject();
		 String password = userData.get("User").getAsString();
		 	       
	    }
	   
	    public void clickLoginButton() {
	        LoginBtn.click();
	    }
	    public boolean isLogoutButtonVisible() {
	        return LogoutBtn.isDisplayed();
	    }
	    public void logout() {
	        LogoutBtn.click();
	    }
	    public String GetErrorMsg() {
			//LoggerLoad.info("verify the warn message");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String wmes1=errorMsg.getText();
			//LoggerLoad.warn(wmes1);
			return wmes1;
		}
	    public void warningUserName() {
			
			@SuppressWarnings("unused")
			String validationMessage = uname.getAttribute("validationMessage");
			LoggerLoad.info("Please check username");
		}
		public void warningPassword(String String) {
			
			@SuppressWarnings("unused")
			String validationMessage = pwd.getAttribute("validationMessage");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			LoggerLoad.info("Please check password");
		
		}
		public void warningUnamePwd(String String) {
			
			@SuppressWarnings("unused")
			String validationMessage = pwd.getAttribute("validationMessage");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			LoggerLoad.info("Please check username/password");
		
		}
		public void enterUsernameOnly(String username) {
	    	uname.sendKeys(username);
	    	
	    }
	    public void enterPasswordOnly(String password) {
	    	pwd.sendKeys(password);
}
	    public void submitLoginBtnWithKeyboard() {
	        	           
	        actions.sendKeys(LoginBtn, Keys.ENTER).perform();
	    }
	    public void clickLoginButtonWithMouse() {
	       	        
	        actions.click(LoginBtn).build().perform();
	    }
	    public void clickResetPwdLink() {
   	        
	        resetpwd.click();;
	    }
		
}
	        
