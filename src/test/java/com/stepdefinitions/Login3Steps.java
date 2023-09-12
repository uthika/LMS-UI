package com.stepdefinitions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pages.Login1Page;
import com.pages.Login2Page;
import com.pages.Login3Page;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login3Steps {
	private WebDriver driver;
	 private Login1Page loginPage1=new Login1Page(DriverFactory.getDriver());
	 private Login2Page loginPage2=new Login2Page(DriverFactory.getDriver());
	 private Login3Page loginPage3=new Login3Page(DriverFactory.getDriver());
	 
	 @Given("Admin is in login page after clicking login button in home page")
	 public void admin_is_in_login_page_after_clicking_login_button_in_home_page() {
		 loginPage1.navigateToValidURL();
		 loginPage1.clickLoginBtn();
		 loginPage2.verifyLoginPage();
		 
	 }

	 @When("Admin clicks forgot username or password link")
	 public void admin_clicks_forgot_username_or_password_link() {
	     loginPage3.clickForgotLink();
	 }

	 @Then("Admin should land on forgot username or password page")
	 public void admin_should_land_on_forgot_username_or_password_page() {
		 String title = loginPage2.verifyPageTitle();
		 Assert.assertEquals("Forgot Username or Password Page", title);
	 }

	 @Then("Admin should see {string} text in gray color")
	 public void admin_should_see_text_in_gray_color(String string) {
		 String userTextColor = loginPage3.getEmailTextColor();
		  // Define the expected gray color value (you may need to adjust this based on your CSS)
		  String expectedGrayColor = "rgb(128, 128, 128)";
		  Assert.assertEquals(expectedGrayColor, userTextColor, "User text is not displayed in gray color.");
		}
	

	 @Then("Admin should see {string} in text field")
	 public void admin_should_see_in_text_field(String expectedText) {
		 String actualText = loginPage3.getTextFieldText();
	     Assert.assertEquals("Email", actualText);
	 }

	 @Then("Admin should see {string} button")
	 public void admin_should_see_button(String string) {
		 boolean isSendLinkDisplayed = loginPage3.isSendLinkDisplayed(); 
	        Assert.assertTrue(isSendLinkDisplayed, "Send Link button is not displayed.");
	 }

	 @Then("Admin should see asterisk symbol near Email text")
	 public void admin_should_see_asterisk_symbol_near_email_text() {
	     loginPage3.verifyEmailSymbolIsDisplayed();
	 }

	 @Then("Admin should see send link button in the center of the page")
	 public void admin_should_see_send_link_button_in_the_center_of_the_page() {
		 loginPage2.verifyInputFieldCentered();
	 }

	 @Given("Admin is in forgot username and password page")
	 public void admin_is_in_forgot_username_and_password_page() {
	   loginPage3.clickForgotLink();
	   String title = loginPage3.verifyPageTitle();
	   Assert.assertEquals("Forgot Username or Password Page", title);
	   
	 }

	 @When("Admin enters valid email id and clicks send link button")
	 public void admin_enters_valid_email_id_and_clicks_send_link_button() {
		 loginPage3.enterValidEmail("Tim@numpyninja.com");
		    loginPage3.clickSendLink();
		}
	 

	 @Then("Admin should receive link in mail for reset username / password")
	 public void admin_should_receive_link_in_mail_for_reset_username_password() {
		 boolean emailReceived = loginPage3.hasResetLinkEmailArrived();
	    Assert.assertTrue(emailReceived, "Admin should receive the reset link email");
		}
	 

	 @When("Admin enters invalid email id and clicks send link button")
	 public void admin_enters_invalid_email_id_and_clicks_send_link_button() {
		 loginPage3.enterValidEmail("Tim@numpyninja.c");
		    loginPage3.clickSendLink();
	 }

	 @Then("Admin should not receive link in mail for reset username // password")
	 public void admin_should_not_receive_link_in_mail_for_reset_username_password() {
		 boolean linkNotReceived = loginPage3.resetLinknotreceived();
	 }


}
