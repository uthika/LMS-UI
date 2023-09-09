package com.stepdefinitions;
import com.pages.Assignment1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Assignment1Steps extends Assignment1 {

    @Given("Admin is on dashboard page after Login")
    public void admin_is_on_dashboard_page_after_login() {
        dashboard();
    }
    @When("Admin clicks {string} button on the navigation bar")
    public void admin_clicks_button_on_the_navigation_bar(String string) {
        clickAssignmentButton();
    }
    @Then("Admin should see URL with {string}")
    public void admin_should_see_url_with(String string) {
        ManageURL();
    }
    @Then("Get the response time for navigation from dashboard page to manage assignment page")
    public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_assignment_page() {
        validateResponseTime();
    }
    @Then("Admin should see header with {string}")
    public void admin_should_see_header_with(String string) {
        verifyHeader();
    }

    @When("Admin clicks {string} button on the navigation bar and get all text from the portal page")
    public void admin_clicks_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page(String string) {

    }
    @Then("Admin should see correct spelling for the all the fields")
    public void admin_should_see_correct_spelling_for_the_all_the_fields() {

    }
    @Then("Admin should see disabled delete icon below the {string}")
    public void admin_should_see_disabled_delete_icon_below_the(String string) {
        verifyDeleteicon();

    }
    @Then("Admin should see search bar on the manage assignment page")
    public void admin_should_see_search_bar_on_the_manage_assignment_page() {
        verifySearchBar();
    }

}
