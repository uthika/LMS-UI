package com.stepdefinitions;
import com.pages.*;
import io.cucumber.java.en.*;

public class User3Steps extends User3 {
    @Given("The edit icon on row level in data table is enabled")
    public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
        editicononrow();
    }

    @When("Admin clicks the edit icon")
    public void admin_clicks_the_edit_icon() {
        click ();
    }

    @Then("A new pop up with User details appears")
    public void a_new_pop_up_with_user_details_appears() {
        popup();
    }

        @When("Update the fields with valid values and click submit")
    public void update_the_fields_with_valid_values_and_click_submit() {
            submitclick();
    }

    @Then("The updated user details should appear on the data table")
    public void the_updated_user_details_should_appear_on_the_data_table() {
        updaterow();
    }

    @Then("Error message should appear")@When("Erase data from mandatory field")
    public void erase_data_from_mandatory_field() {
        verifyerrormsg();
    }

    @When("Erase data from description field")
    public void erase_data_from_description_field() {
        eraseDataFromDescriptionField();
    }



}
