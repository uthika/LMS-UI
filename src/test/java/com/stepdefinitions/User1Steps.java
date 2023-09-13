package com.stepdefinitions;
import com.pages.User1;
import io.cucumber.java.en.*;
public class User1Steps extends User1{
    @When("Admin clicks {string} from navigation bar")
    public void admin_clicks_from_navigation_bar(String string) {
        navigation();
    }

    @Then("Admin should see the {string} in the URL")
    public void admin_should_see_the_in_the_url(String string) {
        string();
    }

    @Then("Admin should see the {string} in the header")
    public void admin_should_see_the_in_the_header(String string) {
        header();
    }

    @Then("Admin should see the pagination controls under the data table")
    public void admin_should_see_the_pagination_controls_under_the_data_table() {
        pagination();
    }

    @Then("Admin Should see the data table with headers Id, Name, location, Phone Number, Edit\\/Delete")
    public void admin_should_see_the_data_table_with_headers_id_name_location_phone_number_edit_delete() {
        headerdisplay();
    }

    @Then("Admin should be able to see the {string} icon button that is disabled")
    public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
        buttondisable();
    }

    @Then("Admin should be able to see the {string} button")
    public void admin_should_be_able_to_see_the_button(String string) {
        stringbutton();
    }

    @Then("Admin should be able to see the search text box")
    public void admin_should_be_able_to_see_the_search_text_box() {
        searchtextbox();
    }

    @Then("Each row in the data table should have a checkbox")
    public void each_row_in_the_data_table_should_have_a_checkbox() {
        checkbox();
    }

    @Then("Each row in the data table should have a delete icon that is enabled")
    public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
        deleteicon();
    }

    @When("Admin clicks {string} button")
    public void admin_clicks_button(String string) {
        button();
    }

    @Then("A new pop up with User details appears")
    public void a_new_pop_up_with_user_details_appears() {
        userdetails();
    }
}
