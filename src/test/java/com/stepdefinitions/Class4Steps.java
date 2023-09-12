package com.stepdefinitions;

import com.pages.Class4;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class4Steps extends Class4 {

	@When("Admin clicks Edit button in data table")
	public void admin_clicks_edit_button_in_data_table() {
	    classEdit();
	}

	@Then("Edit popup window appears with heading Class Details")
	public void edit_popup_window_appears_with_heading_class_details() {
	    editPopUp();
	}

	@When("Admin clicks Edit button from one of the row in data table")
	public void admin_clicks_edit_button_from_one_of_the_row_in_data_table() {
		ClassEditrow();
	}

	@Then("Edit popup window appears with same row values in the all fields")
	public void edit_popup_window_appears_with_same_row_values_in_the_all_fields() {
		ClassEditrowPopup();
	}

	@Given("Admin is in Edit class detail popup window")
	public void admin_is_in_edit_class_detail_popup_window() {
		editPopUp();
	}

	@Then("Admin should see particular class details is updated in the data table")
	public void admin_should_see_particular_class_details_is_updated_in_the_data_table() {
		updatedData();
	}

}