package com.stepdefinitions;

import com.pages.Class2;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class2Steps extends Class2 {
	
	@When("Admin click +Add New Class button")
	public void admin_click_add_new_class_button() {
	    addNewclass();
	}

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String string) {
	    classDetailsheader();
	}

	@Then("Admin should see input fields Text {string}")
	public void admin_should_see_input_fields_text(String field) {
	   
		classDetailsField(field);
		
	}

	@Then("{int} textbox should be  present in Class details popup window")
	public void textbox_should_be_present_in_class_details_popup_window(Integer int1) {
	    textBoxSize();
	}

	@Then("Admin should see  dropdown option for Batch ID")
	public void admin_should_see_dropdown_option_for_batch_id() {
	    ddBatchId();
	}

	@Then("Admin should see  dropdown option for Staff Id")
	public void admin_should_see_dropdown_option_for_staff_id() {
	    ddStaffId();
	}

	@Then("Admin should see  calendar icon for class date")
	public void admin_should_see_calendar_icon_for_class_date() {
		cCalender();	
		}

	@Then("Admin should see  save button in the class detail popup window")
	public void admin_should_see_save_button_in_the_class_detail_popup_window() {
	    saveClass();
	}

	@Then("Admin should see  cancel button in the class detail popup window")
	public void admin_should_see_cancel_button_in_the_class_detail_popup_window() {
	    cancelClass();
	}

	@Then("Admin should see  close button on the class details popup window")
	public void admin_should_see_close_button_on_the_class_details_popup_window() {
	    deleteClass();
	}


}
