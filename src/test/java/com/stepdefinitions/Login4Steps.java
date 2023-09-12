package com.stepdefinitions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.pages.Login2Page;
import com.pages.Login3Page;
import com.qa.factory.DriverFactory;
import com.pages.Login4Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login4Steps {
	
	private Login3Page loginPage3=new Login3Page(DriverFactory.getDriver());
	private Login4Page loginPage4=new Login4Page(DriverFactory.getDriver());
	private Login2Page loginPage2=new Login2Page(DriverFactory.getDriver());
	
	@When("Admin clicks reset password link here")
	public void admin_clicks_reset_password_link_here() {
	    loginPage2.clickResetPwdLink();
	}

	@Then("Admin should land on reset password page here")
	public void admin_should_land_on_reset_password_page_here() {
		 String title = loginPage4.verifyPageTitle();
		 Assert.assertEquals("Reset Password Page", title);
	}

	@Then("Admin should see correct spellings in all fields here")
	public void admin_should_see_correct_spellings_in_all_fields_here() {
		boolean areCorrectSpellings = loginPage4.areSpellingsCorrectInAllFields();
    	Assert.assertTrue(areCorrectSpellings, "Incorrect spellings found in one or more fields.");
	}

	@Then("Admin should see {string} button here")
	public void admin_should_see_button_here(String string) {
	    loginPage4.issubmitBtnDisplayed();
	}

	@Then("Admin should see submit button in center of the page here")
	public void admin_should_see_submit_button_in_center_of_the_page_here() {
		loginPage2.verifyInputFieldCentered();
	}

	@Then("Admin should see two text boxes here")
	public void admin_should_see_two_text_boxes_here() {
		boolean areTextFieldsVisible = loginPage4.areTextFieldsVisible();   
	     Assert.assertTrue(areTextFieldsVisible, "Two text fields should be visible");
	}

	@Then("Admin should see {string} in the first label text here")
	public void admin_should_see_in_the_first_label_text_here(String expectedText) {
		String actualText = loginPage4.getNewPwdText();
	     Assert.assertEquals(expectedText, actualText);
	}
	

	@Then("Admin should see {string} in the second label text here")
	public void admin_should_see_in_the_second_label_text_here(String expectedText) {
		String actualText = loginPage4.getRetypePwdText();
	     Assert.assertEquals(expectedText, actualText);
	}

	@Then("Admin should see text box in disabled state here")
	public void admin_should_see_text_box_in_disabled_state_here() {
		boolean isTextBoxDisabled = loginPage4.isTextBoxDisabled();
	    Assert.assertTrue(isTextBoxDisabled, "Text box is not in a disabled state.");
	}
	
	@Given("Admin clicks reset password link after reaching in login page")
	public void admin_clicks_reset_password_link_after_reaching_in_login_page() {
	    loginPage2.clickResetPwdLink();
	}

	@When("Admin is navigated reset password page")
	public void admin_is_navigated_reset_password_page() {
		String title = loginPage4.verifyPageTitle();
		 Assert.assertEquals("Reset Password Page", title);
	}

	@When("Admin clicks on {string} field here")
	public void admin_clicks_on_field_here(String string) {
		loginPage4.clickTypeInNewPasswordField();
	}
	@When("Admin clicks on {string} next field here")
	public void admin_clicks_on_next_field_here(String fieldLabel) {
	    loginPage4.clickRetypePasswordField();
	}

	@Then("Admin should see text box is enabled state here")
	public void admin_should_see_text_box_is_enabled_state_here() {
		boolean isTextBoxEnabled = loginPage4.isTypeInNewPasswordTextBoxEnabled();
	    Assert.assertTrue(isTextBoxEnabled, "Text box is not in an enabled state.");
	}

	@Given("Admin is in reset password page")
	public void admin_is_in_reset_password_page() {
		 String title = loginPage4.verifyPageTitle();
		 Assert.assertEquals("Reset Password Page", title);
	}

	@When("Admin enters the same password on both fields and clicks submit button here")
	public void admin_enters_the_same_password_on_both_fields_and_clicks_submit_button_here() {
		loginPage4.enterSamePasswordInFieldsAndSubmit();
	}

	@Then("Admin should receive: {string} here")
	public void admin_should_receive_here(String expectedMessage) {
		String actualMessage = loginPage4.getResetPasswordConfirmationMessage(); 
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("Admin enters the same password on both fields with invalid details and clicks submit button here")
	public void admin_enters_the_same_password_on_both_fields_with_invalid_details_and_clicks_submit_button_here() {
	    loginPage4.enterInvalidPasswordInFieldsAndSubmit();
	}

	@Then("Admin should see an error message: {string} here")
	public void admin_should_see_an_error_message_here(String errorMessage) {
		String actualErrorMessage = loginPage4.getErrorMessage(); 
	    Assert.assertEquals(errorMessage, actualErrorMessage);
	}

	@When("Admin enters empty details on both fields and clicks submit button here")
	public void admin_enters_empty_details_on_both_fields_and_clicks_submit_button_here() {
		loginPage4.clickTypeInNewPasswordField();
		loginPage4.clickRetypePasswordField();
		loginPage4.clickSubmitBtn();
	}

	@When("Admin enters mismatch values and clicks submit button here")
	public void admin_enters_mismatch_values_and_clicks_submit_button_here() {
	    loginPage4.enterMismatchpwdAndClickSubmit();
	}
	


}