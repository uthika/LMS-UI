package com.stepdefinitions;

import com.pages.Class3;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class3Steps extends Class3 {
	
	@Given("Admin is in  class detail popup window")
	public void admin_is_in_class_detail_popup_window() {
		ClassPage();
	}

	@When("Admin clicks  Batch ID dropdown")
	public void admin_clicks_batch_id_dropdown() {
		ddBatchId();
	}

	@Then("Batch id in the drop down should match with Batch id manage batch page table")
	public void batch_id_in_the_drop_down_should_match_with_batch_id_manage_batch_page_table() {
		ddBatchID();
	}

	@When("Admin enters all mandatory field {string} with valid {int} and clicks save button")
	public void admin_enters_all_mandatory_field_with_valid_and_clicks_save_button(String sheetname, int rownumber) {
	   dataentryAdd(sheetname, rownumber);
	}

	@Then("Admin should see success message {string}")
	public void admin_should_see_success_message(String string) {
		datavalidaddmsg();  
	}

	@When("Admin enters with invalid {string} data {int} and clicks save button")
	public void admin_enters_with_invalid_data_and_clicks_save_button(String sheetname, int rownumber) {
		 dataentryAdd(sheetname, rownumber);
	}
	
	@Then("Error message should appear in alert")
	public void error_message_should_appear_in_alert() {
	     errorMsg();
	}
	
	@When("Admin enters data missing value in {string} {int} and clicks save button")
	public void admin_enters_data_missing_value_in_and_clicks_save_button(String sheetname, int rownumber) {
		 dataentryAdd(sheetname, rownumber);
	}
	
	@Then("Error message displays is missing")
	public void error_message_displays_is_missing() {
	    errorMsg();
	}
	
	@When("Admin clicks date from date picker")
	public void admin_clicks_date_from_date_picker() {
	    datePicker();
	}

	@Then("selected date should be their in class date text box")
	public void selected_date_should_be_their_in_class_date_text_box() {
		 validatedate();
	}

	@Then("selected date should be in  mm\\/dd\\/yyyy format")
	public void selected_date_should_be_in_mm_dd_yyyy_format() {
		formatDate();
	}

	@When("Admin clicks right arrow in the date picker near month")
	public void admin_clicks_right_arrow_in_the_date_picker_near_month() {
		DatepickerRarrow();
	}

	@Then("Next month calender should visible")
	public void next_month_calender_should_visible() {
		nextMonth();
	}

	@When("Admin clicks left arrow in the date picker near month")
	public void admin_clicks_left_arrow_in_the_date_picker_near_month() {
	     DatepickerLArrow();
	}

	@Then("previous month calender should visible")
	public void previous_month_calender_should_visible() {
		prevMonth();
	}

	@When("Admin clicks date picker button")
	public void admin_clicks_date_picker_button() {
		 dataPickerButton();
	}

	@Then("Admin should see current date is highled in the date picker")
	public void admin_should_see_current_date_is_highled_in_the_date_picker() {
		currentdate();
	}

	@When("Admin clicks date picker button and selects future date")
	public void admin_clicks_date_picker_button_and_selects_future_date() {
		futuredate();
	}

	@Then("Admin should see selected date is highled in the date picker")
	public void admin_should_see_selected_date_is_highled_in_the_date_picker() {
		selecteddate();
	}

	@When("Admin clicks Cancel button without entering values in the fields")
	public void admin_clicks_cancel_button_without_entering_values_in_the_fields() {
	    cancelEmpty();
	}

	@Then("Admin should land on Manage Class page")
	public void admin_should_land_on_manage_class_page() {
		ClassPage();
	}


}
