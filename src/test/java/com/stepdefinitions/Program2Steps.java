package com.stepdefinitions;
import com.pages.Program2;
import io.cucumber.java.en.*;

public class Program2Steps extends Program2 {
    @When("Admin clicks <A New Program>button")
    public void admin_clicks_a_new_program_button() {
button();
    }

    @Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
    public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
        popup();
    }

    @Then("Admin should see two input fields and their respective text boxes in the program details window")
    public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
        inputFields();
    }

    @Then("Admin should see two radio button for Program Status")
    public void admin_should_see_two_radio_button_for_program_status() {
        radiobutton();
    }

    @Given("Admin is on {string} Popup window")
    public void admin_is_on_popup_window(String string) {
        popupWithRowData();
    }

    @When("Admin clicks <Save>button without entering any data")
    public void admin_clicks_save_button_without_entering_any_data() {
  Savebutton();
    }

    @Then("Admin gets a Error message alert")
    public void admin_gets_a_error_message_alert() {
        alert();
    }

    @When("Admin enters only<Program Name> in text box and clicks Save button")
    public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
        Name();
    }

    @Then("Admin gets a message alert {string}")
    public void admin_gets_a_message_alert(String string) {
        alertmsg();
    }

    @When("Admin enters only<Program description> in text box and clicks Save button")
    public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
        progdescription();
    }

    @When("Admin selects only Status and clicks Save button")
    public void admin_selects_only_status_and_clicks_save_button() {
        alertmsgforstatus();
    }

    @When("Admin enters only numbers or special char in name and desc column")
    public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column() {

    }

    @When("Admin clicks Cancel\\/Close\\(X) Icon on Program Details form")
    public void admin_clicks_cancel_close_x_icon_on_program_details_form() {
     Cancelbutton();
    }

    @Then("Program Details popup window should be closed without saving")
    public void program_details_popup_window_should_be_closed_without_saving() {

    }

    @When("Enter all the required fields with valid values and click Save button")
    public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {
        allfield();
    }

    @Then("Admin gets a message {string} alert and able to see the new program added in the data table")
    public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {

    }

    @When("Admin clicks <Cancel>button")
    public void admin_clicks_cancel_button() {
        CLICKbutton();
    }

    @Then("Admin can see the Program details popup disappears without creating any program")
    public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {

    }

}
