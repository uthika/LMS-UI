package com.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.Class7;

public class Class7Steps extends Class7{
	
	@When("Admin click on Batch id column header to sort")
	public void admin_click_on_batch_id_column_header_to_sort() {
	    sortingHeader();
	}

	@Then("Admin should see data table sorted in descending  order")
	public void admin_should_see_data_table_sorted_in_descending_order() {
	   desOrder();
	}

	@When("Admin double click on Batch id column header to sort")
	public void admin_double_click_on_batch_id_column_header_to_sort() {
	    columnHeader();
	}

	@Then("Admin should see data table sorted in ascending  order")
	public void admin_should_see_data_table_sorted_in_ascending_order() {
	    ascOrder();
	}


}

