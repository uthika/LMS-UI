package com.stepdefinitions;

import com.pages.Class9;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class9Steps extends Class9 {
	
		@When("Admin clicks {string} button in the navigation bar")
		public void admin_clicks_button_in_the_navigation_bar(String pages) {
			validateNavig(pages);
		}

		@Then("Admin should able to land on {string} page")
		public void admin_should_able_to_land_on_page(String string) {
			assertPageTitle(string);
		}

	

}
