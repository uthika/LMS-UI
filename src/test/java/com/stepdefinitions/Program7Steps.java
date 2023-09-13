package com.stepdefinitions;
import com.pages.User1;
import io.cucumber.java.en.*;
import com.pages.*;
public class Program7Steps extends Program7{
    @Given("Admin is on Manage Program page")
    public void admin_is_on_manage_program_page() {
        clickAssignmentButton();
    }

    @When("Admin clicks Next page link on the program table")
    public void admin_clicks_next_page_link_on_the_program_table() {
        displayPage();
    }

    @Then("Admin should see the Pagination has {string} link")
    public void admin_should_see_the_pagination_has_link(String string) {
        paginationlink();
    }

    @When("Admin clicks Last page link")
    public void admin_clicks_last_page_link() {
        Lastpagelink();
    }

    @Then("Admin should see the last page record on the table with Next page link are disabled")
    public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
        nxtPagedisabled();
    }

    @Given("Admin is on last page of Program table")
    public void admin_is_on_last_page_of_program_table() {
        lastpage();
    }

    @When("Admin clicks First page link")
    public void admin_clicks_first_page_link() {
        pagelink();
    }

    @Then("Admin should see the previous page record on the table with pagination has previous page link")
    public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
        VerifyPreviousPageRecord();
    }

    @Given("Admin is on Previous Program page")
    public void admin_is_on_previous_program_page() {

    }

    @When("Admin clicks Start page link")
    public void admin_clicks_start_page_link() {
        startpagelink();
    }

    @Then("Admin should see the very first page record on the table with Previous page link are disabled")
    public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
        nxtPagedisabled();
    }

}
