package com.stepdefinitions;
import com.pages.User1;
import io.cucumber.java.en.*;
import com.pages.*;

public class Program6Steps extends Program6 {
    @Given("Admin is on Manage Program page")
    public void admin_is_on_manage_program_page() {
        navigation();
    }

    @When("Admin clicks the sort icon of program name column")
    public void admin_clicks_the_sort_icon_of_program_name_column() {
        clickToSort();
    }

    @Then("The data get sorted on the table based on the program name column values in ascending order")
    public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
        validateAsc();
    }

    @Given("The data is in the ascending order on the table based on Program Name column")
    public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
        validateAsc();
    }

    @Then("The data get sorted on the table based on the program name column values in descending order")
    public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
        sortDesc ();
    }

    @Then("The data get sorted on the table based on the program description column values in ascending order")
    public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
        validateAsc();
    }

    @Given("The data is in the ascending order on the table based on Program Description column")
    public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {
        validateAscdescription();
    }



    @Then("The data get sorted on the table based on the program status column values in descending order")
    public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
        colinasssnsorted();
    }
}
