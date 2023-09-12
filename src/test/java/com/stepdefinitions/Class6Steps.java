package com.stepdefinitions;
import com.pages.Class6;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class6Steps extends Class6 {
	
	@When("Admin clicks single row level check box in the data table")
	public void admin_clicks_single_row_level_check_box_in_the_data_table() {
	   singleCheck();
	}


	@Then("Admin should see delete icon below the header is enabled")
	public void admin_should_see_delete_icon_below_the_header_is_enabled() {
	    deleteIcEnbld();
	}

	@When("Admin clicks multiple row level check box in the data table")
	public void admin_clicks_multiple_row_level_check_box_in_the_data_table() {
	    multiCheck();
	}

	@Then("Admin should see tick mark in check box  of the selected rows")
	public void admin_should_see_tick_mark_in_check_box_of_the_selected_rows() {
	   enbldbox();
	}

	@Then("Admin should land on manage class page and validate particular class details are deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_deleted_from_the_data_table() {
	  ManageClassvalidton();
	}



}
