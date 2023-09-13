package com.stepdefinitions;
import com.pages.Program3;
import io.cucumber.java.en.*;

public class Program3Steps extends Program3{
    @When("Admin clicks <Edit> button on the data table for any row")
public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
   Editbutton();
}

    @Then("Admin should see a popup open for Program details to edit")
    public void admin_should_see_a_popup_open_for_program_details_to_edit() {
        editPopup();
    }

    @Given("Admin is on Program Details Popup window to Edit")
    public void admin_is_on_program_details_popup_window_to_edit() {
        Editbutton();
    }

    @When("Admin edits the Name column and clicks save button")
    public void admin_edits_the_name_column_and_clicks_save_button() {
        adminEditsNameColumnAndClicksSave();
    }

    @Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
    public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {

    }

    @When("Admin edits the Description column and clicks save button")
    public void admin_edits_the_description_column_and_clicks_save_button() {

        adminEditsDescriptionAndClicksSave();
    }

    @Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
    public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {

    }

    @When("Admin changes the Status and clicks save button")
    public void admin_changes_the_status_and_clicks_save_button() {
        adminChangesStatusAndClicksSave();
    }

    @Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
    public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
        msgalert();
    }

    @When("Admin enters only numbers or special char in name and desc column")
    public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column() {
       Adminvalidation();

    }

    @Then("Admin gets a Error message alert")
    public void admin_gets_a_error_message_alert() {
        verifyErrorMessageAlert();
    }

    @When("Admin clicks <Cancel>button on edit popup")
    public void admin_clicks_cancel_button_on_edit_popup() {
        adminClicksCancelButtonOnEditPopup();
    }

    @Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
    public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
        verifyPopupDisappearsAndNothingChanged();
    }

    @When("Admin clicks <Save>button on edit popup")
    public void admin_clicks_save_button_on_edit_popup() {
        adminClicksSaveButtonOnEditPopup();
    }

    @Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
    public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {

    }


}
