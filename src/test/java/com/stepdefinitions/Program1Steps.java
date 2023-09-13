package com.stepdefinitions;
import com.pages.Program1;
import io.cucumber.java.en.*;

public class Program1Steps extends Program1 {
    @When("Admin clicks {string} on the navigation bar")
    public void admin_clicks_on_the_navigation_bar(String string) {
        clickProgButton();
    }

    @Then("Admin should see a heading with text {string} on the page")
    public void admin_should_see_a_heading_with_text_on_the_page(String string) {
        verifyHeader();
    }

    @Then("Admin should see the text as {string} along with Pagination icon below the table.")
    public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
        Paginationtext();
    }

    @Then("Admin should see the footer as {string}.")
    public void admin_should_see_the_footer_as(String string) {
        footertext();
    }

    @Then("Admin should see a Delete button on the top left hand side as Disabled")
    public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
        verifyDeleteicon();
    }

    @Then("Admin should see a {string} button on the program page above the data table")
    public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
        buttondisplay();
    }

    @Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
    public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
        noofrows();
    }
    @Then("Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
    public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
        tableheader();
    }

    @Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
    public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {

    }

    @Then("Admin should see check box on the left side in all rows of the data table")
    public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
        validatecheckbox();
    }


    @Then("Admin should see the Edit and Delete buttons on each row of the data table")
    public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {

    }

    @Then("Admin should see Search bar with text as {string}")
    public void admin_should_see_search_bar_with_text_as(String string) {
        verifySearchBar();
    }




    @Given("Admin is on Manage Program Page")
    public void admin_is_on_manage_program_page() {
        ManageProgramPage();
    }

    @When("Admin enters <Program name phrase> into search box.")
    public void admin_enters_program_name_phrase_into_search_box() {
        manageprognameph();
    }

    @Then("Admin should see the Programs displayed based on the Program Name")
    public void admin_should_see_the_programs_displayed_based_on_the_program_name() {

    }

    @When("Admin enters <Program description phrase> into search box.")
    public void admin_enters_program_description_phrase_into_search_box() {
    searchboxtext();
    }

    @Then("Admin should see the Programs displayed based on the Program Description")
    public void admin_should_see_the_programs_displayed_based_on_the_program_description() {
        Progdescription();
    }

    @When("Admin enters <Program status phrase> into search box.")
    public void admin_enters_program_status_phrase_into_search_box() {
       progstatus();
    }

    @Then("Admin should see the Programs displayed based on the Program Status")
    public void admin_should_see_the_programs_displayed_based_on_the_program_status() {
 statusdisplay();
    }

    @When("Admin enters the keywords not present in the data table on the Search box")
    public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box() {

    }

    @Then("Admin should see zero entries on the data table")
    public void admin_should_see_zero_entries_on_the_data_table() {

    }

}
