package com.stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.Dashboard1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoard extends Dashboard1{
	
	
	
	
	public DashBoard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Given("Admin clicks Login button after giving correct URL")
	public void admin_clicks_login_button_after_giving_correct_url() {
	   Loginbutton();
	}
	
	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		
		Login();
	    
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
	   
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
		
		validateDashboardTitle();
	   
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		
		validateTitlePosition();
	   
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
	    validateText();
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		lmsTitle();
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		validateNavigationbar();
	}

	@Then("Admin should see student in the 1st place")
	public void admin_should_see_student_in_the_1st_place() {
		positionOfStudent();
	}

	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() {
		positionOfProgram();
	}

	@Then("Admin should see batch in the 3rd place")
	public void admin_should_see_batch_in_the_3rd_place() {
		positionOfBatch();
	}

	@Then("Admin should see class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() {
		positionOfClass();
	}

	@Then("Admin should see student in the  5th user")
	public void admin_should_see_student_in_the_5th_user() {
		positionOfUser();
	}

	@Then("Admin should see student in the  6th assignment")
	public void admin_should_see_student_in_the_6th_assignment() {
		 positionOfAssignment();
	}

	@Then("Admin should see student in the  7th attendance")
	public void admin_should_see_student_in_the_7th_attendance() {
		positionOfAttendance();
	}

	@Then("Admin should see student in the 8th logout")
	public void admin_should_see_student_in_the_8th_logout() {
		positionOfLogout();
	}



}
