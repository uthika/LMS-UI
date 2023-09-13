package com.stepdefinitions;
import com.pages.*;
import io.cucumber.java.en.*;
public class Program5Steps extends Program5 {
    @Given("Admin is on Confirm Deletion alert")
    public void admin_is_on_confirm_deletion_alert() {
        deletealert();
    }

    @When("Admin clicks any checkbox in the data table")
    public void admin_clicks_any_checkbox_in_the_data_table() {
        Checkbox();
    }

    @Then("Admin should see common delete option enabled under header Manage Program")
    public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
        verifydelete();
    }

    @When("Admin clicks <YES> button on the alert")
    public void admin_clicks_yes_button_on_the_alert() {
        clickYesOption();
    }

    @When("Admin clicks <NO> button on the alert")
    public void admin_clicks_no_button_on_the_alert() {
        clicknoOption();
    }

    @Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
    public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
        ValidateDeletion();
    }

    @Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
    public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
        ValidatenonDeletion();
    }

}
