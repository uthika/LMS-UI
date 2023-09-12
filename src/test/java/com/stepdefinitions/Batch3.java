package com.stepdefinitions;

import com.pages.Batch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Batch3 extends Batch {
	
	@When("Admin clicks \"\"Batch\"\" from navigation bar\"")
	public void admin_clicks_batch_from_navigation_bar() {
		batchClick();
	    
	}

	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
		isEnableDelete();
	}

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
	    clickDeleteIcon();
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
		
		isAlertPresent();
	    
	}

	@Given("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon1() {
		clickDeleteIcon();
	}

	@When("You click yes option")
	public void you_click_yes_option() {
		alertAccept();
	    
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {
		
		pop();
	    
	}

	@When("you click No option")
	public void you_click_no_option() {
		alertDismiss();
	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() {
	   
		checkBatchListed();
	}


}
