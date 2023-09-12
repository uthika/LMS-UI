package com.stepdefinitions;
import com.pages.Class5;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class5Steps extends Class5 {
	
	@When("Admin clicks delete button in data table row level")
	public void admin_clicks_delete_button_in_data_table_row_level() {
	    deleteRow();
	}

	@Then("Admin should see alert")
	public void admin_should_see_alert() {
	    alertValidate();
	}

	@Then("Alert should have {string} button to accept")
	public void alert_should_have_button_to_accept(String string) {
	    acceptYesButton();
	}

	@Then("Alert should have {string} button to reject")
	public void alert_should_have_button_to_reject(String string) {
	   rejectNoButton();
	}

	@Given("Admin is in delete alert")
	public void admin_is_in_delete_alert() {
	    deleteAlert();
	}

	@When("Admin clicks yes button")
	public void admin_clicks_yes_button() {
	    clickYes();
	}

	@Then("Success message and validate particular class details are deleted from the data table")
	public void success_message_and_validate_particular_class_details_are_deleted_from_the_data_table() {
	    successValidation();
	}

	@When("Admin clicks no button")
	public void admin_clicks_no_button() {
	   clickNo();
	}

	@Then("Admin should land on manage class page and validate particular class details are not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_deleted_from_the_data_table() {
		validateDeletion();
	}


}
