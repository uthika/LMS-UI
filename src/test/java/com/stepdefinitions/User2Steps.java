package com.stepdefinitions;
import com.pages.Program3;
import io.cucumber.java.en.*;
import com.pages.*;

public class User2Steps extends User2 {

    @Given("A new pop up with user details appears")
    public void a_new_pop_up_with_user_details_appears() {

    }

    @Then("{string}")
    public void string(String string) {
        String();
    }


    @Then("The newly added user should be present in the data table in Manage User page")
    public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
        verifyNewUserInDataTable();
    }

    @When("Fill in all the fields with valid values and click submit")
    public void fill_in_all_the_fields_with_valid_values_and_click_submit() {
        fieldvalue();
    }

    @When("any of the fields have invalid values")
    public void any_of_the_fields_have_invalid_values() {
        invalidvalue();
    }

    @Then("Error message should appear")
    public void error_message_should_appear() {
        errorMessageShouldAppear();
    }

    @When("Any of the mandatory fields are blank")
    public void any_of_the_mandatory_fields_are_blank() {
        checkForBlankMandatoryFields();
    }




}
