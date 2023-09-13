package com.stepdefinitions;

import com.pages.Batch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Batch5 extends Batch {
	
	

	

	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
		editEnable();
	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
		selectEditIcon();
	}

	

	
	@When("Update the fields with valid values and click save")
	public void update_the_fields_with_valid_values_and_click_save() {
		AllValidData();
	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() {
		selectEditIcon();
		AllValidData();
	}

	@When("Erase data from mandatory field")
	public void erase_data_from_mandatory_field() {
		eraseDatafields();
	}

	


}
