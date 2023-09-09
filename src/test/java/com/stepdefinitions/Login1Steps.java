package com.stepdefinitions;

import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class Login1Steps {
    private WebDriver driver;
    public Login1Steps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @Given("Admin launch the browser")
    public void admin_launch_the_browser() {
        driver.get("https://www.amazon.com/");
    }

    @When("Admin gives the correct LMS portal URL")
    public void admin_gives_the_correct_lms_portal_url() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should land on the home page")
    public void admin_should_land_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
