package com.stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.Point;

import com.google.gson.JsonObject;
import com.pages.Login1Page;
import com.pages.Login2Page;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.JSONReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Login2Steps  {
	ConfigReader CR = new ConfigReader();
    Properties prop = CR.init_prop();
	JSONReader jsonreader = new JSONReader();
    String filepath = prop.getProperty("TestdataPath");
    JsonObject jsondata = jsonreader.readJsonData(filepath);

	 
	private WebDriver driver;
	 private Login1Page loginPage1=new Login1Page(DriverFactory.getDriver());
	 private Login2Page loginPage2=new Login2Page(DriverFactory.getDriver());
	
	 @Given("Admin gives the correct LMS portal URL")
	 public void admin_gives_the_correct_lms_portal_url() {
		 loginPage1.navigateToValidURL();
	 }

	 @Given("Admin is in home page")
	 public void admin_is_in_home_page() {
		 String title = loginPage1.verifyHomePage();
	    	Assert.assertTrue(title.contains("/home"));
	 }

	 @When("Admin clicks Login button")
	 public void admin_clicks_login_button() {
	     loginPage1.clickLoginBtn();
	 }

	 @Then("Admin should land on the login page")
	 public void admin_should_land_on_the_login_page() {
		 loginPage2.verifyLoginPage();
	    }
	

	 @Then("HTTP response >= {int}. Then the link is broken")
	 public void http_response_then_the_link_is_broken(Integer expectedResponseCode) {
		 boolean isBroken = loginPage2.isLinkBroken("https://example.com/link", expectedResponseCode);
		 Assert.assertTrue(isBroken, "The link is not broken.");
	 }

	 @Then("Admin should see {string} in the header")
	 public void admin_should_see_in_the_header(String expectedHeaderText) {
		 String actualHeaderText = loginPage2.getHeaderText();
	     Assert.assertEquals(expectedHeaderText, actualHeaderText);
	 }

	 @Then("Admin should see two text fields")
	 public void admin_should_see_two_text_fields() {
		 boolean areTextFieldsVisible = loginPage2.areTextFieldsVisible();   
	     Assert.assertTrue(areTextFieldsVisible, "Two text fields should be visible");
	 }

	 @Then("Admin should see {string} in the first text field")
	 public void admin_should_see_in_the_first_text_field(String expectedText) {
		 String actualText = loginPage2.getFirstTextFieldText();
	     Assert.assertEquals(expectedText, actualText);
	 }

	 @Then("Admin should see * symbol next to user text")
	 public void admin_should_see_symbol_next_to_user_text() {
		 loginPage2.verifyUserSymbolIsDisplayed();
	 }

	 @Then("Admin should see {string} in the second text field")
	 public void admin_should_see_in_the_second_text_field(String expectedText) {
		 String actualText = loginPage2.getsecondTextFieldText();
	     Assert.assertEquals(expectedText, actualText);
	 }

	 @Then("Admin should see * symbol next to password text")
	 public void admin_should_see_symbol_next_to_password_text() {
	     loginPage2.verifyPwdSymbolIsDisplayed();
	 }

	 @Then("Admin should see input field in the center of the page")
	 public void admin_should_see_input_field_in_the_center_of_the_page() {
		 loginPage2.verifyInputFieldCentered();
		 }
	
	 @Then("Admin should see login button")
	 public void admin_should_see_login_button() {
		 boolean isLoginButtonVisible = loginPage2.isLoginButtonVisible(); 
	        Assert.assertTrue(isLoginButtonVisible, "Login button is not displayed.");
	 }

	 @Then("Admin should see login button in the center of the page")
	 public void admin_should_see_login_button_in_the_center_of_the_page() {
		 boolean isLoginButtonCentered = loginPage2.isLoginButtonCentered(); 
	     Assert.assertTrue(isLoginButtonCentered, "Login button is not in the center of the page.");
	    }
	 
	 @Then("Admin should see forgot username or password link")
	 public void admin_should_see_forgot_username_or_password_link() {
		 boolean isForgotLinkDisplayed = loginPage2.isForgotLinkDisplayed();
		 Assert.assertTrue(isForgotLinkDisplayed, "Forgot username or password link is not displayed.");
		}
	 
	 @Then("Admin should see reset password link")
	 public void admin_should_see_reset_password_link() {
		 boolean resetlink = loginPage2.resetPwdLinkDisplayed();
		 Assert.assertTrue(resetlink, "Reset  Password link is not displayed.");
	 }

	 @Then("Admin should see user in gray color")
	 public void admin_should_see_user_in_gray_color() {
		 String userTextColor = loginPage2.getUserTextColor();
		  // Define the expected gray color value (you may need to adjust this based on your CSS)
		  String expectedGrayColor = "rgb(128, 128, 128)";
		  Assert.assertEquals(expectedGrayColor, userTextColor, "User text is not displayed in gray color.");
		}

	 @Then("Admin should see password in gray color")
	 public void admin_should_see_password_in_gray_color() {
		 String pwdTextColor = loginPage2.getPwdTextColor();
		 // Define the expected gray color value (you may need to adjust this based on your CSS)
		  String expectedGrayColor = "rgb(128, 128, 128)";
		  Assert.assertEquals(expectedGrayColor, pwdTextColor, "User text is not displayed in gray color.");
		}
	
	 @Given("Admin in login page after clicking login button in home page")
	 public void admin_in_login_page_after_clicking_login_button_in_home_page() throws InterruptedException {
		 loginPage1.clickLoginBtn();
		 Thread.sleep(2000);
		 loginPage2.verifyLoginPage();
	 }
	 

	 @When("Admin enter valid credentials and clicks login button")
	 public void admin_enter_valid_credentials_and_clicks_login_button() {
		 loginPage2.loginWithValidCredentials(); 
	        loginPage2.clickLoginButton();
	 }

	 @Then("Admin should land on the dashboard page")
	 public void admin_should_land_on_the_dashboard_page() {
		 boolean isLogoutButtonVisible = loginPage2.isLoginButtonVisible(); 
	     Assert.assertTrue(isLogoutButtonVisible, "Admin is not on dashboard page.");
	     loginPage2.logout();
	 }

	 @Given("Admin is in login page")
	 public void admin_is_in_login_page() {
		 loginPage1.clickLoginBtn();
	 }

	 @When("Admin enter invalid credentials and clicks login button")
	 public void admin_enter_invalid_credentials_and_clicks_login_button() {
	     loginPage2.loginWithInvalidCredentials();
	     loginPage2.clickLoginButton();
	 }

	 @Then("Error message {string} should be displayed")
	 public void error_message_should_be_displayed(String string) {
	     loginPage2.warningUnamePwd(string);
	 }

	 @When("Admin enter valid username and clicks login button")
	 public void admin_enter_valid_username_and_clicks_login_button() {
	     loginPage2.enterUsername();
	     loginPage2.clickLoginButton();
	 }

	 @When("Admin enter valid password and clicks login button")
	 public void admin_enter_valid_password_and_clicks_login_button(String password) {
	     loginPage2.enterpassword();
	     loginPage2.clickLoginButton();
	 }

	 @When("Admin enter blank in username and clicks login button")
	 public void admin_enter_blank_in_username_and_clicks_login_button(String password) {
	     loginPage2.enterpassword();;
	     loginPage2.clickLoginButton();
	 }

	 @When("Admin enter blank in password and clicks login button")
	 public void admin_enter_blank_in_password_and_clicks_login_button() {
		 loginPage2.clickLoginButton();
	 }

	 @When("Admin clicks Login button with empty values in both columns")
	 public void admin_clicks_login_button_with_empty_values_in_both_columns() {
		 loginPage2.clickLoginButton();
	 }

	 @When("Admin enter valid credentials and clicks login button through keyboard")
	 public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
	    loginPage2.submitLoginBtnWithKeyboard();
	 }

	 @When("Admin enter valid credentials and clicks login button through mouse")
	 public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		 loginPage2.clickLoginButtonWithMouse();
	 }

	
	
}


