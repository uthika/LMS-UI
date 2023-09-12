package com.pages;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.net.HttpURLConnection;
import java.net.URL;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

public class Login1Page {
	
	private WebDriver driver;

	
	// 1. By Locators: Object Repository
 
	@FindBy (xpath ="//button[text()='Login']") WebElement LoginBtn;
	@FindBy(xpath = "//html")  WebElement htmlElement;
	@FindBy (xpath ="//a[@class='navbar-brand']") WebElement homepage;
	@FindBy(tagName = "a") List<WebElement> links;
	@FindBy(id = "logoElementId")WebElement logo;
	@FindBy(id = "headerElementId") WebElement headerElement;
	
	// 2. Constructor of the page class:
	public Login1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	
	//3.page actions:features(behaviour) of the page the form of methods
	public void clickLoginBtn() {
		LoginBtn.click();
	}

	public void navigateToValidURL() {
        driver.get("https://LMS.com/home");
//        driver.get("https://www.amazon.com/");
    }
	
	public String gethomepagetitle()
	{
		String title=driver.getTitle();
		System.out.println("title"+title);
		return title;
	}
	
	public String verifyHomePage() {
		String title = driver.getTitle();
		return title;
	}
	
	public void navigateToInvalidURL() {
//        driver.get("https://www.amazon.com/ds");
		driver.get("\"https://LMS.com/home");
    }

    public int getHTTPResponseCode() {
    	int responseCode = 0;
        try {
            String status = htmlElement.getAttribute("status");
            responseCode = Integer.parseInt(status);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return responseCode;
    }   
         
     
    
    public void checkForBrokenLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                try {
                  URL url = new URL(href);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println("Broken link found: " + href + " (Status code: " + responseCode + ")");
                    }
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String logintext() {
    return LoginBtn.getText();
}
    public boolean verifyCorrectSpellings() {
        String text1 = logintext();
        // Replace with expected spellings
        String expectedText1 = "Login";
        boolean isField1Correct = text1.equals(expectedText1);
        return isField1Correct /* && other field verifications */;
    }
    
    public boolean isLogoDisplayed() {
    return logo.isDisplayed();
}
    public boolean isLogoProperlyAligned() {
        // Get the location (X, Y coordinates) of the logo and header elements
        int logoX = logo.getLocation().getX();
        int headerX = headerElement.getLocation().getX();
        
        boolean isAligned = logoX == headerX;

        return isAligned;
    }
    
    public boolean isLoginButtonDisplayed() {
        return LoginBtn.isDisplayed();
    }
         
    
}