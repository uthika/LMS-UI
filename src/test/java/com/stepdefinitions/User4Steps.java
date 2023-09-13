package com.stepdefinitions;
import com.pages.*;
import io.cucumber.java.en.*;
public class User4Steps extends User4{
    @Given("The delete icon on row level in data table is enabled")
    public void the_delete_icon_on_row_level_in_data_table_is_enabled() {

    }

    @When("Admin clicks the delete icon")
    public void admin_clicks_the_delete_icon() {
        clickDeleteIconForRow();
    }

    @Then("Alert appears with yes and No option")
    public void alert_appears_with_yes_and_no_option() {
        handleDeleteConfirmationAlert();
    }
    @When("Admin click yes option")
    public void admin_click_yes_option() {
        clickYesOption();
    }

    @Then("User deleted alert pops and user is no more available in data table")
    public void user_deleted_alert_pops_and_user_is_no_more_available_in_data_table() {

    }

    @When("Admin click No option")
    public void admin_click_no_option() {
        clickYesOption();
    }

    @Then("User is still listed in data table")
    public void user_is_still_listed_in_data_table() {
        datatable();
    }

    @Given("None of the checkboxes in data table are selected")
    public void none_of_the_checkboxes_in_data_table_are_selected() {
        Checkbox();
    }

    @Then("The delete icon under the {string} header should be disabled")
    public void the_delete_icon_under_the_header_should_be_disabled(String string) {

    }

    @Given("One of the checkbox\\/ row is selected")
    public void one_of_the_checkbox_row_is_selected() {
        checkbox1();
    }

    @When("Click delete icon below {string} header")
    public void click_delete_icon_below_header(String string) {
        header();
    }

    @Then("The respective row in the data table is deleted")
    public void the_respective_row_in_the_data_table_is_deleted() {
        verifyrowisdeleted();
    }




}
