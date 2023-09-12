package com.stepdefinitions;

import com.pages.Student;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Student2 extends Student{
	
	@Given("Admin is on student details page")
	public void admin_is_on_student_details_page() {
		geturl();
	}

	@When("Admin select student name from the drop down")
	public void admin_select_student_name_from_the_drop_down() {
		selectStudent();
	}

	@Then("Admin shouldn't see select student name text")
	public void admin_shouldn_t_see_select_student_name_text() {
		notfoundtext();
	}

	@When("Admin select batch id from the drop down")
	public void admin_select_batch_id_from_the_drop_down() {
		selectbatchid();
	}

	@Then("Admin shouldn't see select batch id text")
	public void admin_shouldn_t_see_select_batch_id_text() {
		notfoundtext1();
	}

	@When("Admin clicks select student name and  enters x alphabet in the search box")
	public void admin_clicks_select_student_name_and_enters_x_alphabet_in_the_search_box() {
		enterOnddtext();
	}

	@Then("Admin should see student name start with x is listed below")
	public void admin_should_see_student_name_start_with_x_is_listed_below() {
		enterOnddtext();
	}

	@When("Admin  clicks select batch id and enter x number in the search box")
	public void admin_clicks_select_batch_id_and_enter_x_number_in_the_search_box() {
		enterOnddtext2();
		selectStudent();
	}

	@Then("Admin should see batch id start with x is listed below")
	public void admin_should_see_batch_id_start_with_x_is_listed_below() {
		enterOnddtext2();
		selectbatchid();
	}

	@When("Admin selects only student name")
	public void admin_selects_only_student_name() {
		selectStudent();
	}

	@Then("Student details shouldn't be displayed")
	public void student_details_shouldn_t_be_displayed() {
		isstudendetailDisplayed();
	}

	@When("Admin selects only  batch id")
	public void admin_selects_only_batch_id() {
		selectbatchid();
	}

	@When("Admin selects  student name and batch id")
	public void admin_selects_student_name_and_batch_id() {
		selectStudent();
		selectbatchid();
	}

	@Then("Particular student informations should be display")
	public void particular_student_informations_should_be_display() {
		particularStudent();
	}


}
