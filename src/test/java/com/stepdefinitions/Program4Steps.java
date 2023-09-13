package com.stepdefinitions;
import com.pages.*;
import io.cucumber.java.en.*;
public class Program4Steps extends Program4 {
    @When("Admin clicks <Delete> button on the data table for any row")
    public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
        rowDeletebutton();
    }

    @Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
    public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
        validateDialogBox();
    }


    @Given("Admin is on Confirm Deletion alert")
    public void admin_is_on_confirm_deletion_alert() {
        acceptAlert();
    }

    @When("Admin clicks <YES> button on the alert")
    public void admin_clicks_yes_button_on_the_alert() {
        validateYes();
    }

    @Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
    public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) {
        validateDeleteAlert();
    }

    @When("Admin clicks <NO> button on the alert")
    public void admin_clicks_no_button_on_the_alert() {
        validateNo();
    }

    @Then("Admin can see the deletion alert disappears without deleting")
    public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
        verifyDeletionAlertDisappears();
    }

    @When("Admin clicks Cancel\\/Close\\(X) Icon on Deletion alert")
    public void admin_clicks_cancel_close_x_icon_on_deletion_alert() {
        adminClicksCloseIconOnDeletionAlert();
    }

}
