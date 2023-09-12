
package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.Class1;


public class Class1Steps extends Class1 {

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		dashboard();
	}

	@When("Admin clicks {string} button on the navigation bar")
	public void admin_clicks_button_on_the_navigation_bar(String string) {
		clickClassButton();
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		manageURL();
		
	}
	
	@Then("Get the response time for navigation from dashboard page to manage class page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_class_page() {
		responseTime();
	    
	}
	
	@Then("Admin should see header with {string}")
	public void admin_should_see_header_with(String ClassHeader) {
	   columnHeader(ClassHeader);
	}

	@When("Admin clicks {string} button on the navigation bar and get all text from the portal page")
	public void admin_clicks_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page(String string) {
		buttonSpell();
		
	}

	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
		correctSpell();
	}

	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String deleteIconDisabled) {
	   disabledIcon();
	}

	@Then("Admin should see search bar on the class page")
	public void admin_should_see_search_bar_on_the_class_page() {
		searchBox();
	}

	@Then("Admin should see +Add New Class button on the class page")
	public void admin_should_see_add_new_class_button_on_the_class_page() {
		addNewClassButton();
	}

	@Then("Admin should see data table on the Manage Class Page With all {string}")  
	public void admin_should_see_data_table_on_the_manage_class_page_with_all_column_headers(String header) {
	    pageHeader();
	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		editClassButton();
	}

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
		editclassButton();
	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		deleteClassButton();
	}

	@Then("Admin cant see delete  Icon in data table")
	public void admin_cant_see_delete_icon_in_data_table() {
		deleteclassButton();
	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
	    sortIcon();
	}

	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {
		checkBox();
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		paginationcontrol();
	}

	@Then("Admin should see the text with total number classes in the data table {string}")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table(String string) {
		footer();
	}
	
	@When("Admin enters batch id into search box")
	public void admin_enters_batch_id_into_search_box() {
	   batchIdSearch();
	}
	
	
	@Then("Displays entries with that batch Id")
	public void displays_entries_with_that_batch_id() {
	    batchIddisplay();
	}


	@When("Admin enters batch id which is not existing the table into search box")
	public void admin_enters_batch_id_which_is_not_existing_the_table_into_search_box() {
		Invalidbatchid();
	}

	@Then("Displays empty details in the data table")
	public void displays_empty_details_in_the_data_table() {
		emptyData();
	}

	@When("Admin enters class no into search box")
	public void admin_enters_class_no_into_search_box() {
	    clasNo();
	}

	@Then("Displays entries with that class no")
	public void displays_entries_with_that_class_no() {
		ValidateclasNo();
	}

	@When("Admin enters class no which is not existing the table into search box")
	public void admin_enters_class_no_which_is_not_existing_the_table_into_search_box() {
	    NoclasNo();
	}

	@When("Admin enters class topic into search box")
	public void admin_enters_class_topic_into_search_box() {
	    clasTopic();
	}

	@Then("Displays entries with that  class topic")
	public void displays_entries_with_that_class_topic() {
	    displayclasTopic();
	}

	@When("Admin enters class topic which is not existing the table into search box")
	public void admin_enters_class_topic_which_is_not_existing_the_table_into_search_box() {
		NonclasTopic();
	}

	@When("Admin enters staff id into search box")
	public void admin_enters_staff_id_into_search_box() {
		stafId();
	}

	@Then("Displays entries with that  staff id")
	public void displays_entries_with_that_staff_id() {
		displaystafId();
	}

	@When("Admin enters staff id which is not existing the table into search box")
	public void admin_enters_staff_id_which_is_not_existing_the_table_into_search_box() {
		NonstaffId();
	}



}