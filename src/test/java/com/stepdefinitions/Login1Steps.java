package com.stepdefinitions;


import com.pages.Login1Page;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login1Steps { 

	private Login1Page loginPage1=new Login1Page(DriverFactory.getDriver());
//	public String validurl=("https://LMS.com/home");
//	public String invalidurl = "https://invalid-lms-url.com";
	 private WebDriver driver;



    @Given("Admin launches the browser")
    public void admin_launches_the_browser() {
        
    }

    @When("Admin navigates to the correct LMS portal URL")
    public void admin_navigates_to_the_correct_lms_portal_url() {
    	loginPage1.navigateToValidURL();
    }
    
    @Then("Admin should land on the home page")
    public void admin_should_land_on_the_home_page() {
    	String title = loginPage1.verifyHomePage();
    	Assert.assertTrue(title.contains("/home"));
    }

    @When("Admin navigates to an invalid LMS portal URL")
    public void admin_navigates_to_an_invalid_lms_portal_url() {
    	loginPage1.navigateToInvalidURL();
    }

    @Then("Admin should receive a {int} Page Not Found error")
    public void admin_should_receive_a_page_not_found_error(Integer expectedResponseCode) {
        int actualResponseCode = loginPage1.getHTTPResponseCode();
         Assert.assertEquals((int) expectedResponseCode, 404);
        driver.quit();
    }

    @Then("HTTP response code should be greater than or equal to {int} indicating broken links")
    public void http_response_code_should_be_greater_than_or_equal_to_indicating_broken_links(Integer int1) {
    	loginPage1.checkForBrokenLinks();
    	driver.quit();
    }

    @Then("Admin should see correct spellings in all fields")
    public void admin_should_see_correct_spellings_in_all_fields() {
//    	String text1 = loginPage1.logintext();
//    	Assert.assertEquals("Login",text1);
    	boolean areCorrectSpellings = loginPage1.verifyCorrectSpellings();
    	Assert.assertTrue(areCorrectSpellings, "Correct spellings are not found in one or more fields.");
    	driver.quit();
    }

    @Then("Admin should see the correct logo of the LMS")
    public void admin_should_see_the_correct_logo_of_the_lms() {
    	 boolean isLogoDisplayed = loginPage1.isLogoDisplayed();
    	 Assert.assertTrue(isLogoDisplayed, "LMS logo is not displayed.");
    	 driver.quit();
    }

    @Then("Admin should see that the logo is properly aligned")
    public void admin_should_see_that_the_logo_is_properly_aligned() {
    	boolean isLogoProperlyAligned = loginPage1.isLogoProperlyAligned();
        // Verify if the logo is properly aligned
        Assert.assertTrue(isLogoProperlyAligned, "The logo is not properly aligned.");
        driver.quit();
    }
    

    @Then("Admin should see the login button")
    public void admin_should_see_the_login_button() {
    	boolean isLoginButtonDisplayed = loginPage1.isLoginButtonDisplayed();
       Assert.assertTrue(isLoginButtonDisplayed, "Login button is not displayed.");

        driver.quit();
    }

    @Then("Admin should be able to click the Login button")
    public void admin_should_be_able_to_click_the_login_button() {
    	loginPage1.clickLoginBtn();               
        driver.quit();
    }

}

