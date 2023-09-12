package com.stepdefinitions;

import com.pages.Class8;
import io.cucumber.java.en.Then;


public class Class8Steps extends Class8 
{
	
	@Then("Right arrow should be enabled in page one  when entries are more than {int} available")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_available(Integer int1) {
	   RightdispPage();
	   
	}

	@Then("Left arrow should be disabled in page one  when entries are more than {int} available")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_available(Integer int1) {
	    leftdispPage();
	}

	@Then("Right arrow should be enabled in page two when entries are more than {int} available")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_available(Integer int1) {
	    RightEnbld();
	}

	@Then("Left arrow should be enabled in page two")
	public void left_arrow_should_be_enabled_in_page_two() {
	    LeftEnbld();
	}

	@Then("Data table should display  page {int}  when entries available")
	public void data_table_should_display_page_when_entries_available(Integer int1) {
	    displayPage();
	}

	@Then("when entries are more than {int} in data table pagination controls enabled")
	public void when_entries_are_more_than_in_data_table_pagination_controls_enabled(Integer int1) {
	   enbldpag();
	}

	@Then("when entries are less than {int} in data table pagination controls disabled")
	public void when_entries_are_less_than_in_data_table_pagination_controls_disabled(Integer int1) {
	    disbldpag();
	}


	@Then("when total class entries above {int} next page is enabled")
	public void when_total_class_entries_above_next_page_is_enabled(Integer int1) {
	    enbldnxtPage();
	}


	@Then("when total class entries  {int} or below next page is disabled")
	public void when_total_class_entries_or_below_next_page_is_disabled(Integer int1) {
	    disbldNxtPage();
	}

}
